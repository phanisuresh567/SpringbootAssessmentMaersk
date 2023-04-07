package com.maersk.springboot.api.service;

import java.util.List;

import com.maersk.springboot.api.model.Color;

public interface ColorService {
	
	public Color addColor(Color color);
	
	public void deleteColor(String colorName);
	
	public Color getColorDataByName(String colorName);

	List<Color> getAllColors();
	
	public Color updateColor(Color color, String colorName);
	
	public Color mixColors(String color1, String color2);
	
}
