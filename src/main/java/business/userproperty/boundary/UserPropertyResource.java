package business.userproperty.boundary;

import business.userproperty.dto.ApartmentPropertyDTO;
import business.userproperty.dto.GaragePropertyDTO;
import business.userproperty.dto.LandPropertyDTO;
import business.userproperty.dto.PropertyServiceOfferDTO;
import business.userproperty.dto.ResidencePropertyDTO;
import business.userproperty.dto.WarehousePropertyDTO;
import business.userproperty.service.UserPropertyService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/userProperty")
public class UserPropertyResource {
  @Inject
  UserPropertyService userPropertyService;

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/acceptPropertyService")
  public String acceptPropertyService(PropertyServiceOfferDTO offer) {
    return userPropertyService.acceptPropertyService(offer.getOperator(), offer.getUser());
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/declinePropertyService")
  public String declinePropertyService(PropertyServiceOfferDTO offer) {
    return userPropertyService.declinePropertyService(offer.getOperator(), offer.getUser());
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/requestCreateApartment")
  public String requestCreateApartment(ApartmentPropertyDTO request) {
    return userPropertyService.requestCreateApartmentProperty(request.getOperator(), request.getUser(),
        request.getPropertyId(), request.getApartmentPrice(),
        request.getPropertyAddress(), request.getPropertyPostalCode(), request.getPropertyDistrict(),
        request.getPropertyCounty(), request.getGrossArea(),
        request.getUsableArea(), request.getBedrooms(), request.getBathrooms(), request.getFloor(),
        request.getParkingSpaces(), request.getElevator(),
        request.getBuildDate(), request.getInstalledEquipment(), request.getAdditionalInformation(),
        request.getDescription(), request.getPhotoReferences());
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/requestCreateGarage")
  public String requestCreateGarage(GaragePropertyDTO request) {
    return userPropertyService.requestCreateGarageProperty(request.getOperator(), request.getUser(),
        request.getPropertyId(), request.getGaragePrice(),
        request.getPropertyAddress(), request.getPropertyPostalCode(), request.getPropertyDistrict(),
        request.getPropertyCounty(),
        request.getGarageArea(), request.getGarageType(), request.getVehicleCapacity(), request.getInstalledEquipment(),
        request.getAdditionalInformation(), request.getDescription(), request.getPhotoReferences());
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/requestCreateLand")
  public String requestCreateLand(LandPropertyDTO request) {
    return userPropertyService.requestCreateLandProperty(request.getOperator(), request.getUser(),
        request.getPropertyId(), request.getLandPrice(),
        request.getPropertyAddress(), request.getPropertyPostalCode(), request.getPropertyDistrict(),
        request.getPropertyCounty(),
        request.getLandType(), request.getTotalLandArea(), request.getMinimumSurfaceForSale(),
        request.getBuildableArea(),
        request.getBuildableFloors(), request.getAccessByRoad(), request.getInstalledEquipment(),
        request.getViableConstructionTypes(),
        request.getAdditionalInformation(), request.getDescription(), request.getPhotoReferences());
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/requestCreateResidence")
  public String requestCreateResidence(ResidencePropertyDTO request) {
    return userPropertyService.requestCreateResidenceProperty(request.getOperator(), request.getUser(),
        request.getPropertyId(), request.getResidencePrice(),
        request.getPropertyAddress(), request.getPropertyPostalCode(), request.getPropertyDistrict(),
        request.getPropertyCounty(),
        request.getGrossArea(), request.getUsableArea(), request.getBedrooms(), request.getBathrooms(),
        request.getFloors(),
        request.getResidenceType(), request.getBackyard(), request.getParking(), request.getBuildDate(),
        request.getOrientation(),
        request.getInstalledEquipment(), request.getAdditionalInformation(), request.getDescription(), request.getPhotoReferences());
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/requestCreateWarehouse")
  public String requestCreateWarehouse(WarehousePropertyDTO request) {
    return userPropertyService.requestCreateWarehouseProperty(request.getOperator(), request.getUser(),
        request.getPropertyId(), request.getWarehousePrice(),
        request.getPropertyAddress(), request.getPropertyPostalCode(), request.getPropertyDistrict(),
        request.getPropertyCounty(),
        request.getWarehouseType(), request.getGrossArea(), request.getUsableArea(), request.getFloors(),
        request.getBuildDate(),
        request.getInstalledEquipment(), request.getAdditionalInformation(), request.getDescription(), request.getPhotoReferences());
  }

  @POST
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/updateApartmentProperty")
  public String updateApartmentProperty(ApartmentPropertyDTO request) {
    return userPropertyService.modifyUserApartmentPropertyFields(request.getOperator(), request.getUser(),request.getApartmentPrice(),
        request.getPropertyAddress(),
        request.getPropertyPostalCode(), request.getPropertyDistrict(), request.getPropertyCounty(),
        request.getGrossArea(), request.getUsableArea(),
        request.getBedrooms(), request.getBathrooms(), request.getFloor(), request.getParkingSpaces(),
        request.getElevator(), request.getBuildDate(),
        request.getInstalledEquipment(), request.getAdditionalInformation(), request.getDescription(), request.getPhotoReferences());
  }

  @POST
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/updateGarageProperty")
  public String updateGarageProperty(GaragePropertyDTO request) {
    return userPropertyService.modifyUserGaragePropertyFields(request.getOperator(), request.getUser(),request.getGaragePrice(),
        request.getPropertyAddress(),
        request.getPropertyPostalCode(), request.getPropertyDistrict(), request.getPropertyCounty(),
        request.getGarageArea(), request.getGarageType(),
        request.getVehicleCapacity(), request.getInstalledEquipment(), request.getAdditionalInformation(),
        request.getDescription(), request.getPhotoReferences());
  }

  @POST
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/updateLandProperty")
  public String updateLandProperty(LandPropertyDTO request) {
    return userPropertyService.modifyUserLandPropertyFields(request.getOperator(), request.getUser(),request.getLandPrice(),
        request.getPropertyAddress(),
        request.getPropertyPostalCode(), request.getPropertyDistrict(), request.getPropertyCounty(),
        request.getLandType(), request.getTotalLandArea(),
        request.getMinimumSurfaceForSale(), request.getBuildableArea(), request.getBuildableFloors(),
        request.getAccessByRoad(), request.getInstalledEquipment(),
        request.getViableConstructionTypes(), request.getAdditionalInformation(), request.getDescription(), request.getPhotoReferences());
  }

  @POST
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/updateResidenceProperty")
  public String updateResidenceProperty(ResidencePropertyDTO request) {
    return userPropertyService.modifyUserResidencePropertyFields(request.getOperator(), request.getUser(),request.getResidencePrice(),
        request.getPropertyAddress(), request.getPropertyPostalCode(), request.getPropertyDistrict(),
        request.getPropertyCounty(),
        request.getGrossArea(), request.getUsableArea(), request.getBedrooms(), request.getBathrooms(),
        request.getFloors(),
        request.getResidenceType(), request.getBackyard(), request.getParking(), request.getBuildDate(),
        request.getOrientation(),
        request.getInstalledEquipment(), request.getAdditionalInformation(), request.getDescription(), request.getPhotoReferences());
  }

  @POST
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/updateWarehouseProperty")
  public String updateWarehouseProperty(WarehousePropertyDTO request) {
    return userPropertyService.modifyUserWarehousePropertyFields(request.getOperator(), request.getUser(),request.getWarehousePrice(),
        request.getPropertyAddress(),
        request.getPropertyPostalCode(), request.getPropertyDistrict(), request.getPropertyCounty(),
        request.getWarehouseType(), request.getGrossArea(),
        request.getUsableArea(), request.getFloors(), request.getBuildDate(), request.getInstalledEquipment(),
        request.getAdditionalInformation(),
        request.getDescription(), request.getPhotoReferences());
  }
}
