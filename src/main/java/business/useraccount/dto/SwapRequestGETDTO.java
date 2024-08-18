package business.useraccount.dto;

import business.userproperty.dto.ApartmentPropertyGETDTO;
import business.userproperty.dto.GaragePropertyGETDTO;
import business.userproperty.dto.LandPropertyGETDTO;
import business.userproperty.dto.ResidencePropertyGETDTO;
import business.userproperty.dto.WarehousePropertyGETDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SwapRequestGETDTO {

  private String sellerId;

  private String buyerId;

  private String propertyType;

  private ApartmentPropertyGETDTO apartmentDTO;

  private LandPropertyGETDTO landDTO;

  private ResidencePropertyGETDTO residenceDTO;

  private GaragePropertyGETDTO garageDTO;

  private WarehousePropertyGETDTO warehouseDTO;

}
