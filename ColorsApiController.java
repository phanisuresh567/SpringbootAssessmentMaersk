package com.maersk.springboot.api;

import static  org.springframework.http.ResponseEntity.ok;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import com.maersk.springboot.api.model.Color;
import com.maersk.springboot.api.service.ColorService;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@RestController
@RequestMapping("${openapi.colorMixingOpenAPI30.base-path:/}")
public class ColorsApiController implements ColorsApi {

    private final NativeWebRequest request;
    
    private final ColorService colorService;

    @org.springframework.beans.factory.annotation.Autowired
    public ColorsApiController(NativeWebRequest request1, ColorService colorService) {
        this.request = request1;
        this.colorService = colorService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

	@Override
	public ResponseEntity<List<Color>> getColors() {
		return ResponseEntity.ok( colorService.getAllColors());
		}

	
	@Override
	public ResponseEntity<Color> addColor(@RequestBody @Valid Color color) {
		return ResponseEntity.ok(colorService.addColor(color));
	}
	
@Override
    public ResponseEntity<Void> deleteColor(@PathVariable("colorName") String colorName) {
    	colorService.deleteColor(colorName);
    	return ResponseEntity.accepted().build();
	}

@Override
	public  ResponseEntity<Color> getColorByName(@PathVariable("colorName") String colorName) {
		return ResponseEntity.ok( colorService.getColorDataByName(colorName));
	}

@Override
    public ResponseEntity<Color> updateColor(@PathVariable("colorName") String colorName, @RequestBody Color color) {
		 colorService.updateColor(color, colorName);
		 return ResponseEntity.accepted().build();
	}

}
