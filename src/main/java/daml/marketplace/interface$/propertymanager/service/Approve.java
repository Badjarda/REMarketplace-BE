package daml.marketplace.interface$.propertymanager.service;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.Party;
import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.codegen.DamlRecord;
import com.daml.ledger.javaapi.data.codegen.PrimitiveValueDecoders;
import com.daml.ledger.javaapi.data.codegen.ValueDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfReader;
import daml.marketplace.interface$.propertymanager.property.apartmentproperty.factory.Factory;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Approve extends DamlRecord<Approve> {
  public static final String _packageId = "e09e7a18c217e8002e4a374c04915d394e5120e173ac8f1ee6decbc2d8c3c8b4";

  public final String operator;

  public final Factory.ContractId apartmentPropertyFactoryCid;

  public final daml.marketplace.interface$.propertymanager.property.landproperty.factory.Factory.ContractId landPropertyFactoryCid;

  public final daml.marketplace.interface$.propertymanager.property.residenceproperty.factory.Factory.ContractId residencePropertyFactoryCid;

  public final daml.marketplace.interface$.propertymanager.property.garageproperty.factory.Factory.ContractId garagePropertyFactoryCid;

  public final daml.marketplace.interface$.propertymanager.property.warehouseproperty.factory.Factory.ContractId warehousePropertyFactoryCid;

  public Approve(String operator, Factory.ContractId apartmentPropertyFactoryCid,
      daml.marketplace.interface$.propertymanager.property.landproperty.factory.Factory.ContractId landPropertyFactoryCid,
      daml.marketplace.interface$.propertymanager.property.residenceproperty.factory.Factory.ContractId residencePropertyFactoryCid,
      daml.marketplace.interface$.propertymanager.property.garageproperty.factory.Factory.ContractId garagePropertyFactoryCid,
      daml.marketplace.interface$.propertymanager.property.warehouseproperty.factory.Factory.ContractId warehousePropertyFactoryCid) {
    this.operator = operator;
    this.apartmentPropertyFactoryCid = apartmentPropertyFactoryCid;
    this.landPropertyFactoryCid = landPropertyFactoryCid;
    this.residencePropertyFactoryCid = residencePropertyFactoryCid;
    this.garagePropertyFactoryCid = garagePropertyFactoryCid;
    this.warehousePropertyFactoryCid = warehousePropertyFactoryCid;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static Approve fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<Approve> valueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<com.daml.ledger.javaapi.data.DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(6,0,
          recordValue$);
      String operator = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      Factory.ContractId apartmentPropertyFactoryCid =
          new Factory.ContractId(fields$.get(1).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected apartmentPropertyFactoryCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      daml.marketplace.interface$.propertymanager.property.landproperty.factory.Factory.ContractId landPropertyFactoryCid =
          new daml.marketplace.interface$.propertymanager.property.landproperty.factory.Factory.ContractId(fields$.get(2).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected landPropertyFactoryCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      daml.marketplace.interface$.propertymanager.property.residenceproperty.factory.Factory.ContractId residencePropertyFactoryCid =
          new daml.marketplace.interface$.propertymanager.property.residenceproperty.factory.Factory.ContractId(fields$.get(3).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected residencePropertyFactoryCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      daml.marketplace.interface$.propertymanager.property.garageproperty.factory.Factory.ContractId garagePropertyFactoryCid =
          new daml.marketplace.interface$.propertymanager.property.garageproperty.factory.Factory.ContractId(fields$.get(4).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected garagePropertyFactoryCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      daml.marketplace.interface$.propertymanager.property.warehouseproperty.factory.Factory.ContractId warehousePropertyFactoryCid =
          new daml.marketplace.interface$.propertymanager.property.warehouseproperty.factory.Factory.ContractId(fields$.get(5).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected warehousePropertyFactoryCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      return new Approve(operator, apartmentPropertyFactoryCid, landPropertyFactoryCid,
          residencePropertyFactoryCid, garagePropertyFactoryCid, warehousePropertyFactoryCid);
    } ;
  }

  public com.daml.ledger.javaapi.data.DamlRecord toValue() {
    ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field> fields = new ArrayList<com.daml.ledger.javaapi.data.DamlRecord.Field>(6);
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("operator", new Party(this.operator)));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("apartmentPropertyFactoryCid", this.apartmentPropertyFactoryCid.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("landPropertyFactoryCid", this.landPropertyFactoryCid.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("residencePropertyFactoryCid", this.residencePropertyFactoryCid.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("garagePropertyFactoryCid", this.garagePropertyFactoryCid.toValue()));
    fields.add(new com.daml.ledger.javaapi.data.DamlRecord.Field("warehousePropertyFactoryCid", this.warehousePropertyFactoryCid.toValue()));
    return new com.daml.ledger.javaapi.data.DamlRecord(fields);
  }

  public static JsonLfDecoder<Approve> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("operator", "apartmentPropertyFactoryCid", "landPropertyFactoryCid", "residencePropertyFactoryCid", "garagePropertyFactoryCid", "warehousePropertyFactoryCid"), name -> {
          switch (name) {
            case "operator": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "apartmentPropertyFactoryCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.marketplace.interface$.propertymanager.property.apartmentproperty.factory.Factory.ContractId::new));
            case "landPropertyFactoryCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.marketplace.interface$.propertymanager.property.landproperty.factory.Factory.ContractId::new));
            case "residencePropertyFactoryCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.marketplace.interface$.propertymanager.property.residenceproperty.factory.Factory.ContractId::new));
            case "garagePropertyFactoryCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.marketplace.interface$.propertymanager.property.garageproperty.factory.Factory.ContractId::new));
            case "warehousePropertyFactoryCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(5, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.marketplace.interface$.propertymanager.property.warehouseproperty.factory.Factory.ContractId::new));
            default: return null;
          }
        }
        , (Object[] args) -> new Approve(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4]), JsonLfDecoders.cast(args[5])));
  }

  public static Approve fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("operator", apply(JsonLfEncoders::party, operator)),
        JsonLfEncoders.Field.of("apartmentPropertyFactoryCid", apply(JsonLfEncoders::contractId, apartmentPropertyFactoryCid)),
        JsonLfEncoders.Field.of("landPropertyFactoryCid", apply(JsonLfEncoders::contractId, landPropertyFactoryCid)),
        JsonLfEncoders.Field.of("residencePropertyFactoryCid", apply(JsonLfEncoders::contractId, residencePropertyFactoryCid)),
        JsonLfEncoders.Field.of("garagePropertyFactoryCid", apply(JsonLfEncoders::contractId, garagePropertyFactoryCid)),
        JsonLfEncoders.Field.of("warehousePropertyFactoryCid", apply(JsonLfEncoders::contractId, warehousePropertyFactoryCid)));
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof Approve)) {
      return false;
    }
    Approve other = (Approve) object;
    return Objects.equals(this.operator, other.operator) &&
        Objects.equals(this.apartmentPropertyFactoryCid, other.apartmentPropertyFactoryCid) &&
        Objects.equals(this.landPropertyFactoryCid, other.landPropertyFactoryCid) &&
        Objects.equals(this.residencePropertyFactoryCid, other.residencePropertyFactoryCid) &&
        Objects.equals(this.garagePropertyFactoryCid, other.garagePropertyFactoryCid) &&
        Objects.equals(this.warehousePropertyFactoryCid, other.warehousePropertyFactoryCid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.operator, this.apartmentPropertyFactoryCid,
        this.landPropertyFactoryCid, this.residencePropertyFactoryCid,
        this.garagePropertyFactoryCid, this.warehousePropertyFactoryCid);
  }

  @Override
  public String toString() {
    return String.format("daml.marketplace.interface$.propertymanager.service.Approve(%s, %s, %s, %s, %s, %s)",
        this.operator, this.apartmentPropertyFactoryCid, this.landPropertyFactoryCid,
        this.residencePropertyFactoryCid, this.garagePropertyFactoryCid,
        this.warehousePropertyFactoryCid);
  }
}
