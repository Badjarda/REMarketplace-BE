package daml.interface$.propertymanager.property.apartmentproperty.apartmentproperty;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.Bool;
import com.daml.ledger.javaapi.data.DamlCollectors;
import com.daml.ledger.javaapi.data.Date;
import com.daml.ledger.javaapi.data.Int64;
import com.daml.ledger.javaapi.data.Numeric;
import com.daml.ledger.javaapi.data.Text;
import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.codegen.DamlRecord;
import com.daml.ledger.javaapi.data.codegen.PrimitiveValueDecoders;
import com.daml.ledger.javaapi.data.codegen.ValueDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfReader;
import java.lang.Boolean;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class UpdateApartment extends DamlRecord<UpdateApartment> {
  public static final String _packageId = "8b6e58552ef878dbcd4586daf541e0ca6dd1b0d75795e7f9ece68259cb3242b1";

  public final BigDecimal newApartmentPrice;

  public final String newApartmentPropertyAddress;

  public final String newApartmentPropertyPostalCode;

  public final String newApartmentPropertyDistrict;

  public final String newApartmentPropertyCounty;

  public final BigDecimal newApartmentGrossArea;

  public final BigDecimal newApartmentUsableArea;

  public final Long newApartmentBedrooms;

  public final Long newApartmentBathrooms;

  public final Long newApartmentFloor;

  public final Long newApartmentParkingSpaces;

  public final Boolean newApartmentElevator;

  public final LocalDate newApartmentBuildDate;

  public final String newApartmentInstalledEquipment;

  public final String newApartmentAdditionalInformation;

  public final String newApartmentDescription;

  public final List<String> newApartmentPhotoReferences;

  public UpdateApartment(BigDecimal newApartmentPrice, String newApartmentPropertyAddress,
      String newApartmentPropertyPostalCode, String newApartmentPropertyDistrict,
      String newApartmentPropertyCounty, BigDecimal newApartmentGrossArea,
      BigDecimal newApartmentUsableArea, Long newApartmentBedrooms, Long newApartmentBathrooms,
      Long newApartmentFloor, Long newApartmentParkingSpaces, Boolean newApartmentElevator,
      LocalDate newApartmentBuildDate, String newApartmentInstalledEquipment,
      String newApartmentAdditionalInformation, String newApartmentDescription,
      List<String> newApartmentPhotoReferences) {
    this.newApartmentPrice = newApartmentPrice;
    this.newApartmentPropertyAddress = newApartmentPropertyAddress;
    this.newApartmentPropertyPostalCode = newApartmentPropertyPostalCode;
    this.newApartmentPropertyDistrict = newApartmentPropertyDistrict;
    this.newApartmentPropertyCounty = newApartmentPropertyCounty;
    this.newApartmentGrossArea = newApartmentGrossArea;
    this.newApartmentUsableArea = newApartmentUsableArea;
    this.newApartmentBedrooms = newApartmentBedrooms;
    this.newApartmentBathrooms = newApartmentBathrooms;
    this.newApartmentFloor = newApartmentFloor;
    this.newApartmentParkingSpaces = newApartmentParkingSpaces;
    this.newApartmentElevator = newApartmentElevator;
    this.newApartmentBuildDate = newApartmentBuildDate;
    this.newApartmentInstalledEquipment = newApartmentInstalledEquipment;
    this.newApartmentAdditionalInformation = newApartmentAdditionalInformation;
    this.newApartmentDescription = newApartmentDescription;
    this.newApartmentPhotoReferences = newApartmentPhotoReferences;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static UpdateApartment fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<UpdateApartment> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(17,0,
          recordValue$);
      BigDecimal newApartmentPrice = PrimitiveValueDecoders.fromNumeric
          .decode(fields$.get(0).getValue());
      String newApartmentPropertyAddress = PrimitiveValueDecoders.fromText
          .decode(fields$.get(1).getValue());
      String newApartmentPropertyPostalCode = PrimitiveValueDecoders.fromText
          .decode(fields$.get(2).getValue());
      String newApartmentPropertyDistrict = PrimitiveValueDecoders.fromText
          .decode(fields$.get(3).getValue());
      String newApartmentPropertyCounty = PrimitiveValueDecoders.fromText
          .decode(fields$.get(4).getValue());
      BigDecimal newApartmentGrossArea = PrimitiveValueDecoders.fromNumeric
          .decode(fields$.get(5).getValue());
      BigDecimal newApartmentUsableArea = PrimitiveValueDecoders.fromNumeric
          .decode(fields$.get(6).getValue());
      Long newApartmentBedrooms = PrimitiveValueDecoders.fromInt64
          .decode(fields$.get(7).getValue());
      Long newApartmentBathrooms = PrimitiveValueDecoders.fromInt64
          .decode(fields$.get(8).getValue());
      Long newApartmentFloor = PrimitiveValueDecoders.fromInt64.decode(fields$.get(9).getValue());
      Long newApartmentParkingSpaces = PrimitiveValueDecoders.fromInt64
          .decode(fields$.get(10).getValue());
      Boolean newApartmentElevator = PrimitiveValueDecoders.fromBool
          .decode(fields$.get(11).getValue());
      LocalDate newApartmentBuildDate = PrimitiveValueDecoders.fromDate
          .decode(fields$.get(12).getValue());
      String newApartmentInstalledEquipment = PrimitiveValueDecoders.fromText
          .decode(fields$.get(13).getValue());
      String newApartmentAdditionalInformation = PrimitiveValueDecoders.fromText
          .decode(fields$.get(14).getValue());
      String newApartmentDescription = PrimitiveValueDecoders.fromText
          .decode(fields$.get(15).getValue());
      List<String> newApartmentPhotoReferences = PrimitiveValueDecoders.fromList(
            PrimitiveValueDecoders.fromText).decode(fields$.get(16).getValue());
      return new UpdateApartment(newApartmentPrice, newApartmentPropertyAddress,
          newApartmentPropertyPostalCode, newApartmentPropertyDistrict, newApartmentPropertyCounty,
          newApartmentGrossArea, newApartmentUsableArea, newApartmentBedrooms,
          newApartmentBathrooms, newApartmentFloor, newApartmentParkingSpaces, newApartmentElevator,
          newApartmentBuildDate, newApartmentInstalledEquipment, newApartmentAdditionalInformation,
          newApartmentDescription, newApartmentPhotoReferences);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(17);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newApartmentPrice", new Numeric(this.newApartmentPrice)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newApartmentPropertyAddress", new Text(this.newApartmentPropertyAddress)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newApartmentPropertyPostalCode", new Text(this.newApartmentPropertyPostalCode)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newApartmentPropertyDistrict", new Text(this.newApartmentPropertyDistrict)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newApartmentPropertyCounty", new Text(this.newApartmentPropertyCounty)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newApartmentGrossArea", new Numeric(this.newApartmentGrossArea)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newApartmentUsableArea", new Numeric(this.newApartmentUsableArea)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newApartmentBedrooms", new Int64(this.newApartmentBedrooms)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newApartmentBathrooms", new Int64(this.newApartmentBathrooms)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newApartmentFloor", new Int64(this.newApartmentFloor)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newApartmentParkingSpaces", new Int64(this.newApartmentParkingSpaces)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newApartmentElevator", Bool.of(this.newApartmentElevator)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newApartmentBuildDate", new Date((int) this.newApartmentBuildDate.toEpochDay())));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newApartmentInstalledEquipment", new Text(this.newApartmentInstalledEquipment)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newApartmentAdditionalInformation", new Text(this.newApartmentAdditionalInformation)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newApartmentDescription", new Text(this.newApartmentDescription)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("newApartmentPhotoReferences", this.newApartmentPhotoReferences.stream().collect(DamlCollectors.toDamlList(v$0 -> new Text(v$0)))));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<UpdateApartment> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("newApartmentPrice", "newApartmentPropertyAddress", "newApartmentPropertyPostalCode", "newApartmentPropertyDistrict", "newApartmentPropertyCounty", "newApartmentGrossArea", "newApartmentUsableArea", "newApartmentBedrooms", "newApartmentBathrooms", "newApartmentFloor", "newApartmentParkingSpaces", "newApartmentElevator", "newApartmentBuildDate", "newApartmentInstalledEquipment", "newApartmentAdditionalInformation", "newApartmentDescription", "newApartmentPhotoReferences"), name -> {
          switch (name) {
            case "newApartmentPrice": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10));
            case "newApartmentPropertyAddress": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "newApartmentPropertyPostalCode": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "newApartmentPropertyDistrict": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "newApartmentPropertyCounty": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "newApartmentGrossArea": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(5, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10));
            case "newApartmentUsableArea": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(6, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.numeric(10));
            case "newApartmentBedrooms": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(7, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64);
            case "newApartmentBathrooms": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(8, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64);
            case "newApartmentFloor": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(9, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64);
            case "newApartmentParkingSpaces": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(10, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.int64);
            case "newApartmentElevator": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(11, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.bool);
            case "newApartmentBuildDate": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(12, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.date);
            case "newApartmentInstalledEquipment": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(13, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "newApartmentAdditionalInformation": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(14, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "newApartmentDescription": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(15, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text);
            case "newApartmentPhotoReferences": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(16, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.list(com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.text));
            default: return null;
          }
        }
        , (Object[] args) -> new UpdateApartment(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4]), JsonLfDecoders.cast(args[5]), JsonLfDecoders.cast(args[6]), JsonLfDecoders.cast(args[7]), JsonLfDecoders.cast(args[8]), JsonLfDecoders.cast(args[9]), JsonLfDecoders.cast(args[10]), JsonLfDecoders.cast(args[11]), JsonLfDecoders.cast(args[12]), JsonLfDecoders.cast(args[13]), JsonLfDecoders.cast(args[14]), JsonLfDecoders.cast(args[15]), JsonLfDecoders.cast(args[16])));
  }

  public static UpdateApartment fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("newApartmentPrice", apply(JsonLfEncoders::numeric, newApartmentPrice)),
        JsonLfEncoders.Field.of("newApartmentPropertyAddress", apply(JsonLfEncoders::text, newApartmentPropertyAddress)),
        JsonLfEncoders.Field.of("newApartmentPropertyPostalCode", apply(JsonLfEncoders::text, newApartmentPropertyPostalCode)),
        JsonLfEncoders.Field.of("newApartmentPropertyDistrict", apply(JsonLfEncoders::text, newApartmentPropertyDistrict)),
        JsonLfEncoders.Field.of("newApartmentPropertyCounty", apply(JsonLfEncoders::text, newApartmentPropertyCounty)),
        JsonLfEncoders.Field.of("newApartmentGrossArea", apply(JsonLfEncoders::numeric, newApartmentGrossArea)),
        JsonLfEncoders.Field.of("newApartmentUsableArea", apply(JsonLfEncoders::numeric, newApartmentUsableArea)),
        JsonLfEncoders.Field.of("newApartmentBedrooms", apply(JsonLfEncoders::int64, newApartmentBedrooms)),
        JsonLfEncoders.Field.of("newApartmentBathrooms", apply(JsonLfEncoders::int64, newApartmentBathrooms)),
        JsonLfEncoders.Field.of("newApartmentFloor", apply(JsonLfEncoders::int64, newApartmentFloor)),
        JsonLfEncoders.Field.of("newApartmentParkingSpaces", apply(JsonLfEncoders::int64, newApartmentParkingSpaces)),
        JsonLfEncoders.Field.of("newApartmentElevator", apply(JsonLfEncoders::bool, newApartmentElevator)),
        JsonLfEncoders.Field.of("newApartmentBuildDate", apply(JsonLfEncoders::date, newApartmentBuildDate)),
        JsonLfEncoders.Field.of("newApartmentInstalledEquipment", apply(JsonLfEncoders::text, newApartmentInstalledEquipment)),
        JsonLfEncoders.Field.of("newApartmentAdditionalInformation", apply(JsonLfEncoders::text, newApartmentAdditionalInformation)),
        JsonLfEncoders.Field.of("newApartmentDescription", apply(JsonLfEncoders::text, newApartmentDescription)),
        JsonLfEncoders.Field.of("newApartmentPhotoReferences", apply(JsonLfEncoders.list(JsonLfEncoders::text), newApartmentPhotoReferences)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof UpdateApartment)) {
      return false;
    }
    UpdateApartment other = (UpdateApartment) object;
    return Objects.equals(this.newApartmentPrice, other.newApartmentPrice) &&
        Objects.equals(this.newApartmentPropertyAddress, other.newApartmentPropertyAddress) &&
        Objects.equals(this.newApartmentPropertyPostalCode, other.newApartmentPropertyPostalCode) &&
        Objects.equals(this.newApartmentPropertyDistrict, other.newApartmentPropertyDistrict) &&
        Objects.equals(this.newApartmentPropertyCounty, other.newApartmentPropertyCounty) &&
        Objects.equals(this.newApartmentGrossArea, other.newApartmentGrossArea) &&
        Objects.equals(this.newApartmentUsableArea, other.newApartmentUsableArea) &&
        Objects.equals(this.newApartmentBedrooms, other.newApartmentBedrooms) &&
        Objects.equals(this.newApartmentBathrooms, other.newApartmentBathrooms) &&
        Objects.equals(this.newApartmentFloor, other.newApartmentFloor) &&
        Objects.equals(this.newApartmentParkingSpaces, other.newApartmentParkingSpaces) &&
        Objects.equals(this.newApartmentElevator, other.newApartmentElevator) &&
        Objects.equals(this.newApartmentBuildDate, other.newApartmentBuildDate) &&
        Objects.equals(this.newApartmentInstalledEquipment, other.newApartmentInstalledEquipment) &&
        Objects.equals(this.newApartmentAdditionalInformation, other.newApartmentAdditionalInformation) &&
        Objects.equals(this.newApartmentDescription, other.newApartmentDescription) &&
        Objects.equals(this.newApartmentPhotoReferences, other.newApartmentPhotoReferences);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.newApartmentPrice, this.newApartmentPropertyAddress,
        this.newApartmentPropertyPostalCode, this.newApartmentPropertyDistrict,
        this.newApartmentPropertyCounty, this.newApartmentGrossArea, this.newApartmentUsableArea,
        this.newApartmentBedrooms, this.newApartmentBathrooms, this.newApartmentFloor,
        this.newApartmentParkingSpaces, this.newApartmentElevator, this.newApartmentBuildDate,
        this.newApartmentInstalledEquipment, this.newApartmentAdditionalInformation,
        this.newApartmentDescription, this.newApartmentPhotoReferences);
  }

  @Override
  public String toString() {
    return String.format("daml.interface$.propertymanager.property.apartmentproperty.apartmentproperty.UpdateApartment(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)",
        this.newApartmentPrice, this.newApartmentPropertyAddress,
        this.newApartmentPropertyPostalCode, this.newApartmentPropertyDistrict,
        this.newApartmentPropertyCounty, this.newApartmentGrossArea, this.newApartmentUsableArea,
        this.newApartmentBedrooms, this.newApartmentBathrooms, this.newApartmentFloor,
        this.newApartmentParkingSpaces, this.newApartmentElevator, this.newApartmentBuildDate,
        this.newApartmentInstalledEquipment, this.newApartmentAdditionalInformation,
        this.newApartmentDescription, this.newApartmentPhotoReferences);
  }
}
