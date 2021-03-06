package org.springframework.samples.petclinic.care;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.PetType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Care extends BaseEntity{
	@NotEmpty
	@Size(min=5,max=30)
	@Column(name="name", unique=true)
	String name;
	@NotEmpty
    String description;
	@NotNull
	@NotEmpty
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name = "compatible_pet_types", joinColumns = @JoinColumn(name = "pet_type_id"),
	inverseJoinColumns = @JoinColumn(name = "care_id"))
    Set<PetType> compatiblePetTypes;
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name = "incompatible_cares", joinColumns = @JoinColumn(name = "care_id1"),
	inverseJoinColumns = @JoinColumn(name = "care_id2"))
	Set<Care> incompatiblesCares;
	
	
}
