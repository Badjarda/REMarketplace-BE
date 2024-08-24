package business.userproperty.boundary;

import java.util.List;
import java.util.Map;

import business.userproperty.dto.ApartmentPropertyDTO;
import business.userproperty.dto.ApartmentPropertyGETDTO;
import business.userproperty.dto.GaragePropertyDTO;
import business.userproperty.dto.GaragePropertyGETDTO;
import business.userproperty.dto.GetPropertyDTO;
import business.userproperty.dto.GetUserProperties;
import business.userproperty.dto.LandPropertyDTO;
import business.userproperty.dto.LandPropertyGETDTO;
import business.userproperty.dto.PropertyServiceOfferDTO;
import business.userproperty.dto.ResidencePropertyDTO;
import business.userproperty.dto.ResidencePropertyGETDTO;
import business.userproperty.dto.WarehousePropertyDTO;
import business.userproperty.dto.WarehousePropertyGETDTO;
import business.userproperty.service.UserPropertyService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
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
    return userPropertyService.acceptPropertyService(offer.getUser());
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/declinePropertyService")
  public String declinePropertyService(PropertyServiceOfferDTO offer) {
    return userPropertyService.declinePropertyService(offer.getUser());
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  @Path("/requestCreateApartment")
  public String requestCreateApartment(ApartmentPropertyDTO request) {
    return userPropertyService.requestCreateApartmentProperty(request.getUser(),
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
    return userPropertyService.requestCreateGarageProperty(request.getUser(),
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
    return userPropertyService.requestCreateLandProperty(request.getUser(),
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
    return userPropertyService.requestCreateResidenceProperty(request.getUser(),
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
    return userPropertyService.requestCreateWarehouseProperty(request.getUser(),
        request.getPropertyId(), request.getWarehousePrice(),
        request.getPropertyAddress(), request.getPropertyPostalCode(), request.getPropertyDistrict(),
        request.getPropertyCounty(),
        request.getWarehouseType(), request.getGrossArea(), request.getUsableArea(), request.getFloors(),
        request.getBuildDate(),
        request.getInstalledEquipment(), request.getAdditionalInformation(), request.getDescription(), request.getPhotoReferences());
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/updateApartmentProperty")
  public String updateApartmentProperty(ApartmentPropertyDTO request) {
    return userPropertyService.modifyUserApartmentPropertyFields(request.getUser(),request.getApartmentPrice(),
        request.getPropertyAddress(),
        request.getPropertyPostalCode(), request.getPropertyDistrict(), request.getPropertyCounty(),
        request.getGrossArea(), request.getUsableArea(),
        request.getBedrooms(), request.getBathrooms(), request.getFloor(), request.getParkingSpaces(),
        request.getElevator(), request.getBuildDate(),
        request.getInstalledEquipment(), request.getAdditionalInformation(), request.getDescription(), request.getPhotoReferences());
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/updateGarageProperty")
  public String updateGarageProperty(GaragePropertyDTO request) {
    return userPropertyService.modifyUserGaragePropertyFields(request.getUser(),request.getGaragePrice(),
        request.getPropertyAddress(),
        request.getPropertyPostalCode(), request.getPropertyDistrict(), request.getPropertyCounty(),
        request.getGarageArea(), request.getGarageType(),
        request.getVehicleCapacity(), request.getInstalledEquipment(), request.getAdditionalInformation(),
        request.getDescription(), request.getPhotoReferences());
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/updateLandProperty")
  public String updateLandProperty(LandPropertyDTO request) {
    return userPropertyService.modifyUserLandPropertyFields(request.getUser(),request.getLandPrice(),
        request.getPropertyAddress(),
        request.getPropertyPostalCode(), request.getPropertyDistrict(), request.getPropertyCounty(),
        request.getLandType(), request.getTotalLandArea(),
        request.getMinimumSurfaceForSale(), request.getBuildableArea(), request.getBuildableFloors(),
        request.getAccessByRoad(), request.getInstalledEquipment(),
        request.getViableConstructionTypes(), request.getAdditionalInformation(), request.getDescription(), request.getPhotoReferences());
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/updateResidenceProperty")
  public String updateResidenceProperty(ResidencePropertyDTO request) {
    return userPropertyService.modifyUserResidencePropertyFields(request.getUser(),request.getResidencePrice(),
        request.getPropertyAddress(), request.getPropertyPostalCode(), request.getPropertyDistrict(),
        request.getPropertyCounty(),
        request.getGrossArea(), request.getUsableArea(), request.getBedrooms(), request.getBathrooms(),
        request.getFloors(),
        request.getResidenceType(), request.getBackyard(), request.getParking(), request.getBuildDate(),
        request.getOrientation(),
        request.getInstalledEquipment(), request.getAdditionalInformation(), request.getDescription(), request.getPhotoReferences());
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/updateWarehouseProperty")
  public String updateWarehouseProperty(WarehousePropertyDTO request) {
    return userPropertyService.modifyUserWarehousePropertyFields(request.getUser(),request.getWarehousePrice(),
        request.getPropertyAddress(),
        request.getPropertyPostalCode(), request.getPropertyDistrict(), request.getPropertyCounty(),
        request.getWarehouseType(), request.getGrossArea(),
        request.getUsableArea(), request.getFloors(), request.getBuildDate(), request.getInstalledEquipment(),
        request.getAdditionalInformation(),
        request.getDescription(), request.getPhotoReferences());
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/allProperties")
  public Map<String, List<?>> getAllProperties() {
      return userPropertyService.getAllProperties();
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/userProperties")
  public Map<String, List<?>> getAllUserProperties(GetUserProperties request) {
      return userPropertyService.getAllUserProperties(request.getOwner());
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/apartments")
  public List<ApartmentPropertyGETDTO> getAllApartmentProperties() {
      return userPropertyService.getAllApartmentProperties();
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/apartment")
  public ApartmentPropertyGETDTO getApartmentPropertyById(GetPropertyDTO request) {
      return userPropertyService.getApartmentPropertyById(request.getPostalCode());
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/garages")
  public List<GaragePropertyGETDTO> getAllGarageProperties() {
      return userPropertyService.getAllGarageProperties();
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/garage")
  public GaragePropertyGETDTO getGaragePropertyById(GetPropertyDTO request) {
      return userPropertyService.getGaragePropertyById(request.getPostalCode());
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/lands")
  public List<LandPropertyGETDTO> getAllLandProperties() {
      return userPropertyService.getAllLandProperties();
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/land")
  public LandPropertyGETDTO getLandPropertyById(GetPropertyDTO request) {
      return userPropertyService.getLandPropertyById(request.getPostalCode());
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/residences")
  public List<ResidencePropertyGETDTO> getAllResidenceProperties() {
      return userPropertyService.getAllResidenceProperties();
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/residence")
  public ResidencePropertyGETDTO getResidencePropertyById(GetPropertyDTO request) {
      return userPropertyService.getResidencePropertyById(request.getPostalCode());
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/warehouses")
  public List<WarehousePropertyGETDTO> getAllWarehouseProperties() {
      return userPropertyService.getAllWarehouseProperties();
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/warehouse")
  public WarehousePropertyGETDTO getWarehousePropertyById(GetPropertyDTO request) {
      return userPropertyService.getWarehousePropertyById(request.getPostalCode());
  }

  
}
