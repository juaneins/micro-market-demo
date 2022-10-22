/**
 * 
 */
package com.market.demo.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.market.demo.domain.Category;
import com.market.demo.persistence.entity.Categoria;

/**
 * @author juaneins_uio
 *
 */
@Mapper(componentModel = "spring")
public interface CategoryMapper {

	@Mappings({ 
		@Mapping(source = "id", target = "categoryId"), 
		@Mapping(source = "descripcion", target = "category"),
		@Mapping(source = "estado", target = "active") 
	})
	Category toCategory(Categoria categoria);

	@InheritInverseConfiguration
	@Mapping(target = "productos", ignore = true)
	Categoria toCategoria(Category category);

}
