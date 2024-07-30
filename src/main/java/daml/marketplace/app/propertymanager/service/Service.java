package daml.app.propertymanager.service;

import static com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders.apply;

import com.daml.ledger.javaapi.data.ContractFilter;
import com.daml.ledger.javaapi.data.CreateAndExerciseCommand;
import com.daml.ledger.javaapi.data.CreateCommand;
import com.daml.ledger.javaapi.data.CreatedEvent;
import com.daml.ledger.javaapi.data.DamlRecord;
import com.daml.ledger.javaapi.data.ExerciseByKeyCommand;
import com.daml.ledger.javaapi.data.ExerciseCommand;
import com.daml.ledger.javaapi.data.Identifier;
import com.daml.ledger.javaapi.data.Party;
import com.daml.ledger.javaapi.data.Template;
import com.daml.ledger.javaapi.data.Unit;
import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.codegen.Choice;
import com.daml.ledger.javaapi.data.codegen.ContractCompanion;
import com.daml.ledger.javaapi.data.codegen.ContractTypeCompanion;
import com.daml.ledger.javaapi.data.codegen.ContractWithKey;
import com.daml.ledger.javaapi.data.codegen.Created;
import com.daml.ledger.javaapi.data.codegen.Exercised;
import com.daml.ledger.javaapi.data.codegen.PrimitiveValueDecoders;
import com.daml.ledger.javaapi.data.codegen.Update;
import com.daml.ledger.javaapi.data.codegen.ValueDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoder;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfEncoders;
import com.daml.ledger.javaapi.data.codegen.json.JsonLfReader;
import daml.da.types.Tuple2;
import daml.interface$.propertymanager.property.apartmentproperty.factory.Factory;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public final class Service extends Template {
  public static final Identifier TEMPLATE_ID = new Identifier("e09e7a18c217e8002e4a374c04915d394e5120e173ac8f1ee6decbc2d8c3c8b4", "App.PropertyManager.Service", "Service");

  public static final Choice<Service, daml.da.internal.template.Archive, Unit> CHOICE_Archive = 
      Choice.create("Archive", value$ -> value$.toValue(), value$ ->
        daml.da.internal.template.Archive.valueDecoder().decode(value$), value$ ->
        PrimitiveValueDecoders.fromUnit.decode(value$));

  public static final ContractCompanion.WithKey<Contract, ContractId, Service, Tuple2<String, String>> COMPANION = 
      new ContractCompanion.WithKey<>("daml.app.propertymanager.service.Service", TEMPLATE_ID,
        ContractId::new, v -> Service.templateValueDecoder().decode(v), Service::fromJson,
        Contract::new, List.of(CHOICE_Archive), e -> Tuple2.<java.lang.String,
        java.lang.String>valueDecoder(PrimitiveValueDecoders.fromParty,
        PrimitiveValueDecoders.fromParty).decode(e));

  public final String operator;

  public final String user;

  public final Factory.ContractId apartmentPropertyFactoryCid;

  public final daml.interface$.propertymanager.property.landproperty.factory.Factory.ContractId landPropertyFactoryCid;

  public final daml.interface$.propertymanager.property.residenceproperty.factory.Factory.ContractId residencePropertyFactoryCid;

  public final daml.interface$.propertymanager.property.garageproperty.factory.Factory.ContractId garagePropertyFactoryCid;

  public final daml.interface$.propertymanager.property.warehouseproperty.factory.Factory.ContractId warehousePropertyFactoryCid;

  public Service(String operator, String user, Factory.ContractId apartmentPropertyFactoryCid,
      daml.interface$.propertymanager.property.landproperty.factory.Factory.ContractId landPropertyFactoryCid,
      daml.interface$.propertymanager.property.residenceproperty.factory.Factory.ContractId residencePropertyFactoryCid,
      daml.interface$.propertymanager.property.garageproperty.factory.Factory.ContractId garagePropertyFactoryCid,
      daml.interface$.propertymanager.property.warehouseproperty.factory.Factory.ContractId warehousePropertyFactoryCid) {
    this.operator = operator;
    this.user = user;
    this.apartmentPropertyFactoryCid = apartmentPropertyFactoryCid;
    this.landPropertyFactoryCid = landPropertyFactoryCid;
    this.residencePropertyFactoryCid = residencePropertyFactoryCid;
    this.garagePropertyFactoryCid = garagePropertyFactoryCid;
    this.warehousePropertyFactoryCid = warehousePropertyFactoryCid;
  }

  @Override
  public Update<Created<ContractId>> create() {
    return new Update.CreateUpdate<ContractId, Created<ContractId>>(new CreateCommand(Service.TEMPLATE_ID, this.toValue()), x -> x, ContractId::new);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseArchive} instead
   */
  @Deprecated
  public static Update<Exercised<Unit>> exerciseByKeyArchive(Tuple2<String, String> key,
      daml.da.internal.template.Archive arg) {
    return byKey(key).exerciseArchive(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code byKey(key).exerciseArchive()} instead
   */
  @Deprecated
  public static Update<Exercised<Unit>> exerciseByKeyArchive(Tuple2<String, String> key) {
    return byKey(key).exerciseArchive();
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseArchive} instead
   */
  @Deprecated
  public Update<Exercised<Unit>> createAndExerciseArchive(daml.da.internal.template.Archive arg) {
    return createAnd().exerciseArchive(arg);
  }

  /**
   * @deprecated since Daml 2.3.0; use {@code createAnd().exerciseArchive} instead
   */
  @Deprecated
  public Update<Exercised<Unit>> createAndExerciseArchive() {
    return createAndExerciseArchive(new daml.da.internal.template.Archive());
  }

  public static Update<Created<ContractId>> create(String operator, String user,
      Factory.ContractId apartmentPropertyFactoryCid,
      daml.interface$.propertymanager.property.landproperty.factory.Factory.ContractId landPropertyFactoryCid,
      daml.interface$.propertymanager.property.residenceproperty.factory.Factory.ContractId residencePropertyFactoryCid,
      daml.interface$.propertymanager.property.garageproperty.factory.Factory.ContractId garagePropertyFactoryCid,
      daml.interface$.propertymanager.property.warehouseproperty.factory.Factory.ContractId warehousePropertyFactoryCid) {
    return new Service(operator, user, apartmentPropertyFactoryCid, landPropertyFactoryCid,
        residencePropertyFactoryCid, garagePropertyFactoryCid,
        warehousePropertyFactoryCid).create();
  }

  @Override
  public CreateAnd createAnd() {
    return new CreateAnd(this);
  }

  @Override
  protected ContractCompanion.WithKey<Contract, ContractId, Service, Tuple2<String, String>> getCompanion(
      ) {
    return COMPANION;
  }

  /**
   * @deprecated since Daml 2.5.0; use {@code valueDecoder} instead
   */
  @Deprecated
  public static Service fromValue(Value value$) throws IllegalArgumentException {
    return valueDecoder().decode(value$);
  }

  public static ValueDecoder<Service> valueDecoder() throws IllegalArgumentException {
    return ContractCompanion.valueDecoder(COMPANION);
  }

  public DamlRecord toValue() {
    ArrayList<DamlRecord.Field> fields = new ArrayList<DamlRecord.Field>(7);
    fields.add(new DamlRecord.Field("operator", new Party(this.operator)));
    fields.add(new DamlRecord.Field("user", new Party(this.user)));
    fields.add(new DamlRecord.Field("apartmentPropertyFactoryCid", this.apartmentPropertyFactoryCid.toValue()));
    fields.add(new DamlRecord.Field("landPropertyFactoryCid", this.landPropertyFactoryCid.toValue()));
    fields.add(new DamlRecord.Field("residencePropertyFactoryCid", this.residencePropertyFactoryCid.toValue()));
    fields.add(new DamlRecord.Field("garagePropertyFactoryCid", this.garagePropertyFactoryCid.toValue()));
    fields.add(new DamlRecord.Field("warehousePropertyFactoryCid", this.warehousePropertyFactoryCid.toValue()));
    return new DamlRecord(fields);
  }

  private static ValueDecoder<Service> templateValueDecoder() throws IllegalArgumentException {
    return value$ -> {
      Value recordValue$ = value$;
      List<DamlRecord.Field> fields$ = PrimitiveValueDecoders.recordCheck(7,0, recordValue$);
      String operator = PrimitiveValueDecoders.fromParty.decode(fields$.get(0).getValue());
      String user = PrimitiveValueDecoders.fromParty.decode(fields$.get(1).getValue());
      Factory.ContractId apartmentPropertyFactoryCid =
          new Factory.ContractId(fields$.get(2).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected apartmentPropertyFactoryCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      daml.interface$.propertymanager.property.landproperty.factory.Factory.ContractId landPropertyFactoryCid =
          new daml.interface$.propertymanager.property.landproperty.factory.Factory.ContractId(fields$.get(3).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected landPropertyFactoryCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      daml.interface$.propertymanager.property.residenceproperty.factory.Factory.ContractId residencePropertyFactoryCid =
          new daml.interface$.propertymanager.property.residenceproperty.factory.Factory.ContractId(fields$.get(4).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected residencePropertyFactoryCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      daml.interface$.propertymanager.property.garageproperty.factory.Factory.ContractId garagePropertyFactoryCid =
          new daml.interface$.propertymanager.property.garageproperty.factory.Factory.ContractId(fields$.get(5).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected garagePropertyFactoryCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      daml.interface$.propertymanager.property.warehouseproperty.factory.Factory.ContractId warehousePropertyFactoryCid =
          new daml.interface$.propertymanager.property.warehouseproperty.factory.Factory.ContractId(fields$.get(6).getValue().asContractId().orElseThrow(() -> new IllegalArgumentException("Expected warehousePropertyFactoryCid to be of type com.daml.ledger.javaapi.data.ContractId")).getValue());
      return new Service(operator, user, apartmentPropertyFactoryCid, landPropertyFactoryCid,
          residencePropertyFactoryCid, garagePropertyFactoryCid, warehousePropertyFactoryCid);
    } ;
  }

  public static JsonLfDecoder<Service> jsonDecoder() {
    return JsonLfDecoders.record(Arrays.asList("operator", "user", "apartmentPropertyFactoryCid", "landPropertyFactoryCid", "residencePropertyFactoryCid", "garagePropertyFactoryCid", "warehousePropertyFactoryCid"), name -> {
          switch (name) {
            case "operator": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(0, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "user": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(1, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.party);
            case "apartmentPropertyFactoryCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(2, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.interface$.propertymanager.property.apartmentproperty.factory.Factory.ContractId::new));
            case "landPropertyFactoryCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(3, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.interface$.propertymanager.property.landproperty.factory.Factory.ContractId::new));
            case "residencePropertyFactoryCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(4, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.interface$.propertymanager.property.residenceproperty.factory.Factory.ContractId::new));
            case "garagePropertyFactoryCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(5, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.interface$.propertymanager.property.garageproperty.factory.Factory.ContractId::new));
            case "warehousePropertyFactoryCid": return com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.JavaArg.at(6, com.daml.ledger.javaapi.data.codegen.json.JsonLfDecoders.contractId(daml.interface$.propertymanager.property.warehouseproperty.factory.Factory.ContractId::new));
            default: return null;
          }
        }
        , (Object[] args) -> new Service(JsonLfDecoders.cast(args[0]), JsonLfDecoders.cast(args[1]), JsonLfDecoders.cast(args[2]), JsonLfDecoders.cast(args[3]), JsonLfDecoders.cast(args[4]), JsonLfDecoders.cast(args[5]), JsonLfDecoders.cast(args[6])));
  }

  public static Service fromJson(String json) throws JsonLfDecoder.Error {
    return jsonDecoder().decode(new JsonLfReader(json));
  }

  public JsonLfEncoder jsonEncoder() {
    return JsonLfEncoders.record(
        JsonLfEncoders.Field.of("operator", apply(JsonLfEncoders::party, operator)),
        JsonLfEncoders.Field.of("user", apply(JsonLfEncoders::party, user)),
        JsonLfEncoders.Field.of("apartmentPropertyFactoryCid", apply(JsonLfEncoders::contractId, apartmentPropertyFactoryCid)),
        JsonLfEncoders.Field.of("landPropertyFactoryCid", apply(JsonLfEncoders::contractId, landPropertyFactoryCid)),
        JsonLfEncoders.Field.of("residencePropertyFactoryCid", apply(JsonLfEncoders::contractId, residencePropertyFactoryCid)),
        JsonLfEncoders.Field.of("garagePropertyFactoryCid", apply(JsonLfEncoders::contractId, garagePropertyFactoryCid)),
        JsonLfEncoders.Field.of("warehousePropertyFactoryCid", apply(JsonLfEncoders::contractId, warehousePropertyFactoryCid)));
  }

  public static ContractFilter<Contract> contractFilter() {
    return ContractFilter.of(COMPANION);
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof Service)) {
      return false;
    }
    Service other = (Service) object;
    return Objects.equals(this.operator, other.operator) && Objects.equals(this.user, other.user) &&
        Objects.equals(this.apartmentPropertyFactoryCid, other.apartmentPropertyFactoryCid) &&
        Objects.equals(this.landPropertyFactoryCid, other.landPropertyFactoryCid) &&
        Objects.equals(this.residencePropertyFactoryCid, other.residencePropertyFactoryCid) &&
        Objects.equals(this.garagePropertyFactoryCid, other.garagePropertyFactoryCid) &&
        Objects.equals(this.warehousePropertyFactoryCid, other.warehousePropertyFactoryCid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.operator, this.user, this.apartmentPropertyFactoryCid,
        this.landPropertyFactoryCid, this.residencePropertyFactoryCid,
        this.garagePropertyFactoryCid, this.warehousePropertyFactoryCid);
  }

  @Override
  public String toString() {
    return String.format("daml.app.propertymanager.service.Service(%s, %s, %s, %s, %s, %s, %s)",
        this.operator, this.user, this.apartmentPropertyFactoryCid, this.landPropertyFactoryCid,
        this.residencePropertyFactoryCid, this.garagePropertyFactoryCid,
        this.warehousePropertyFactoryCid);
  }

  /**
   * Set up an {@link ExerciseByKeyCommand}; invoke an {@code exercise} method on the result of
      this to finish creating the command, or convert to an interface first with {@code toInterface}
      to invoke an interface {@code exercise} method.
   */
  public static ByKey byKey(Tuple2<String, String> key) {
    return new ByKey(key.toValue(v$0 -> new Party(v$0), v$1 -> new Party(v$1)));
  }

  public static final class ContractId extends com.daml.ledger.javaapi.data.codegen.ContractId<Service> implements Exercises<ExerciseCommand> {
    public ContractId(String contractId) {
      super(contractId);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, Service, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public daml.interface$.propertymanager.service.Service.ContractId toInterface(
        daml.interface$.propertymanager.service.Service.INTERFACE_ interfaceCompanion) {
      return new daml.interface$.propertymanager.service.Service.ContractId(this.contractId);
    }

    public daml.interface$.base.service.Service.ContractId toInterface(
        daml.interface$.base.service.Service.INTERFACE_ interfaceCompanion) {
      return new daml.interface$.base.service.Service.ContractId(this.contractId);
    }

    public static ContractId unsafeFromInterface(
        daml.interface$.propertymanager.service.Service.ContractId interfaceContractId) {
      return new ContractId(interfaceContractId.contractId);
    }

    public static ContractId unsafeFromInterface(
        daml.interface$.base.service.Service.ContractId interfaceContractId) {
      return new ContractId(interfaceContractId.contractId);
    }

    public static ContractId fromContractId(
        com.daml.ledger.javaapi.data.codegen.ContractId<Service> contractId) {
      return COMPANION.toContractId(contractId);
    }
  }

  public static class Contract extends ContractWithKey<ContractId, Service, Tuple2<String, String>> {
    public Contract(ContractId id, Service data, Optional<String> agreementText,
        Optional<Tuple2<String, String>> key, Set<String> signatories, Set<String> observers) {
      super(id, data, agreementText, key, signatories, observers);
    }

    @Override
    protected ContractCompanion<Contract, ContractId, Service> getCompanion() {
      return COMPANION;
    }

    public static Contract fromIdAndRecord(String contractId, DamlRecord record$,
        Optional<String> agreementText, Optional<Tuple2<String, String>> key,
        Set<String> signatories, Set<String> observers) {
      return COMPANION.fromIdAndRecord(contractId, record$, agreementText, key, signatories,
          observers);
    }

    public static Contract fromCreatedEvent(CreatedEvent event) {
      return COMPANION.fromCreatedEvent(event);
    }
  }

  public interface Exercises<Cmd> extends com.daml.ledger.javaapi.data.codegen.Exercises.Archive<Cmd> {
    default Update<Exercised<Unit>> exerciseArchive(daml.da.internal.template.Archive arg) {
      return makeExerciseCmd(CHOICE_Archive, arg);
    }

    default Update<Exercised<Unit>> exerciseArchive() {
      return exerciseArchive(new daml.da.internal.template.Archive());
    }
  }

  public static final class CreateAnd extends com.daml.ledger.javaapi.data.codegen.CreateAnd implements Exercises<CreateAndExerciseCommand> {
    CreateAnd(Template createArguments) {
      super(createArguments);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, Service, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public daml.interface$.propertymanager.service.Service.CreateAnd toInterface(
        daml.interface$.propertymanager.service.Service.INTERFACE_ interfaceCompanion) {
      return new daml.interface$.propertymanager.service.Service.CreateAnd(COMPANION, this.createArguments);
    }

    public daml.interface$.base.service.Service.CreateAnd toInterface(
        daml.interface$.base.service.Service.INTERFACE_ interfaceCompanion) {
      return new daml.interface$.base.service.Service.CreateAnd(COMPANION, this.createArguments);
    }
  }

  public static final class ByKey extends com.daml.ledger.javaapi.data.codegen.ByKey implements Exercises<ExerciseByKeyCommand> {
    ByKey(Value key) {
      super(key);
    }

    @Override
    protected ContractTypeCompanion<? extends com.daml.ledger.javaapi.data.codegen.Contract<ContractId, ?>, ContractId, Service, ?> getCompanion(
        ) {
      return COMPANION;
    }

    public daml.interface$.propertymanager.service.Service.ByKey toInterface(
        daml.interface$.propertymanager.service.Service.INTERFACE_ interfaceCompanion) {
      return new daml.interface$.propertymanager.service.Service.ByKey(COMPANION, this.contractKey);
    }

    public daml.interface$.base.service.Service.ByKey toInterface(
        daml.interface$.base.service.Service.INTERFACE_ interfaceCompanion) {
      return new daml.interface$.base.service.Service.ByKey(COMPANION, this.contractKey);
    }
  }
}
