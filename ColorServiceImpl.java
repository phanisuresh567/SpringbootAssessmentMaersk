package com.maersk.springboot.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.maersk.springboot.api.model.Color;
import com.maersk.springboot.api.repository.ColorRepository;

@Service
public class ColorServiceImpl implements ColorService {

	  private ColorRepository repository;

	  public ColorServiceImpl(ColorRepository repository) {
	    this.repository = repository;
	  }

		@Override
		public void deleteColor(String colorName) {
			  repository.deleteById(colorName);

		}

		@Override
		public Color getColorDataByName(String colorName) {
			return repository.findById(colorName).orElse(null);
		}
		

	  @Override
	  public List<Color> getAllColors() {
		  List<Color> result = new ArrayList<>();
		    for (Color str : repository.findAll()) {
		        result.add(str);
		    }
	    return result;
	  }

	@Override
	public Color addColor(Color color) {
		if(repository.findByColorName(color.getColorName()).isEmpty()) {
			return repository.save(color);
		}
		return null;
		
	}

	@Override
	public Color updateColor(Color color, String colorName) {
		Color colorToUpdate = repository.findByColorName(colorName).orElse(null);
		if(colorToUpdate!=null) {
			colorToUpdate.setColorName(color.getColorName());
			colorToUpdate.setR(color.getR());
			colorToUpdate.setG(color.getG());
			colorToUpdate.setB(color.getB());
		}
		return colorToUpdate;
	}

	@Override
	public Color mixColors(String colorName1, String colorName2) {
		Color color1 = repository.findByColorName(colorName1).orElse(null);
		Color color2 = repository.findByColorName(colorName2).orElse(null);

		if(color1 != null && color2 != null) {
			Integer newR = color1.getR() + color2.getR();
			Integer newG = color1.getG() + color2.getG();
			Integer newB = color1.getB() + color2.getB();

			return repository.findByColorCodes(newR, newG, newB).orElse(null);
		}

		return null;

	}


}
