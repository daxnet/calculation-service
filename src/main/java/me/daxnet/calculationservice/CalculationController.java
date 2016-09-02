package me.daxnet.calculationservice;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "api", produces = "application/json")
@RestController
@EnableAutoConfiguration
@RequestMapping("/api")
public class CalculationController {

	@ApiOperation(value = "add", nickname = "add")
	@ApiImplicitParams({
        @ApiImplicitParam(name = "x", value = "The first integer value.", required = true, dataType = "integer", paramType = "path"),
        @ApiImplicitParam(name = "y", value = "The second integer value to be added to the first integer.", required = true, dataType = "integer", paramType = "path")
      })
	@ApiResponses(value = { 
            @ApiResponse(code = 200, message = "Success", response = Integer.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")}) 
	@RequestMapping(method = RequestMethod.GET, path="/add/{x}/{y}", produces = "application/json")
	@ResponseBody
	public int AddInteger(
			@PathVariable("x") int x, 
			@PathVariable("y") int y) {
		return x + y;
	}
}
