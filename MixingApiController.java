package com.maersk.springboot.api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import com.maersk.springboot.api.model.Color;
import com.maersk.springboot.api.service.ColorService;

import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("${openapi.colorMixingOpenAPI30.base-path:/}")
public class MixingApiController implements MixingApi {

    private final NativeWebRequest request;
    
    private final ColorService colorService;

    @org.springframework.beans.factory.annotation.Autowired
    public MixingApiController(NativeWebRequest request, ColorService colorService) {
        this.request = request;
        this.colorService = colorService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

	@Override
	public ResponseEntity<Color> mixColorsByName(@NotNull @Valid String color1, @NotNull @Valid String color2) {
		return ResponseEntity.ok( colorService.mixColors(color1, color2));
	}

}
