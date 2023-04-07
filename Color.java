package com.maersk.springboot.api.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "color")
public class Color extends RepresentationModel<Color>  implements Serializable {
	  private static final long serialVersionUID = 1L;

	  @Id
	  @Column(name = "name", nullable = false)
	  @JsonProperty("name")
	  private String colorName;

	  @JsonProperty("r")
	  @Column(name = "r", nullable = false)
	  private Integer r;

	  @JsonProperty("g")
	  @Column(name = "g", nullable = false)
	  private Integer g;

	  @JsonProperty("b")
	  @Column(name = "b", nullable = false)
	  private Integer b;

	  public Color name(String name) {
	    this.colorName = name;
	    return this;
	  }

	  /**
	   * Name of the color
	   * @return name
	  */
	  @ApiModelProperty(example = "red", required = true, value = "Name of the color")
	  @NotNull
	@Size(max=32) 
	  public String getColorName() {
	    return colorName;
	  }

	  public void setColorName(String name) {
	    this.colorName = name;
	  }

	  public Color r(Integer r) {
	    this.r = r;
	    return this;
	  }

	  /**
	   * red component of color
	   * minimum: 0
	   * maximum: 255
	   * @return r
	  */
	  @ApiModelProperty(example = "255", required = true, value = "red component of color")
	  @NotNull

	@Min(0) @Max(255) 
	  public Integer getR() {
	    return r;
	  }

	  public void setR(Integer r) {
	    this.r = r;
	  }

	  public Color g(Integer g) {
	    this.g = g;
	    return this;
	  }

	  /**
	   * green component of color
	   * minimum: 0
	   * maximum: 255
	   * @return g
	  */
	  @ApiModelProperty(example = "0", required = true, value = "green component of color")
	  @NotNull

	@Min(0) @Max(255) 
	  public Integer getG() {
	    return g;
	  }

	  public void setG(Integer g) {
	    this.g = g;
	  }

	  public Color b(Integer b) {
	    this.b = b;
	    return this;
	  }

	  /**
	   * blue component of color
	   * minimum: 0
	   * maximum: 255
	   * @return b
	  */
	  @ApiModelProperty(example = "0", required = true, value = "blue component of color")
	  @NotNull

	@Min(0) @Max(255) 
	  public Integer getB() {
	    return b;
	  }

	  public void setB(Integer b) {
	    this.b = b;
	  }


	  @Override
	  public boolean equals(java.lang.Object o) {
	    if (this == o) {
	      return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
	      return false;
	    }
	    Color color = (Color) o;
	    return Objects.equals(this.colorName, color.colorName) &&
	        Objects.equals(this.r, color.r) &&
	        Objects.equals(this.g, color.g) &&
	        Objects.equals(this.b, color.b);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(colorName, r, g, b);
	  }

	  @Override
	  public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("class Color {\n");
	    
	    sb.append("    name: ").append(toIndentedString(colorName)).append("\n");
	    sb.append("    r: ").append(toIndentedString(r)).append("\n");
	    sb.append("    g: ").append(toIndentedString(g)).append("\n");
	    sb.append("    b: ").append(toIndentedString(b)).append("\n");
	    sb.append("}");
	    return sb.toString();
	  }

	  /**
	   * Convert the given object to string with each line indented by 4 spaces
	   * (except the first line).
	   */
	  private String toIndentedString(java.lang.Object o) {
	    if (o == null) {
	      return "null";
	    }
	    return o.toString().replace("\n", "\n    ");
	  }
	}