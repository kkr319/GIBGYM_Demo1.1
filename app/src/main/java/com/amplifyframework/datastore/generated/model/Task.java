package com.amplifyframework.datastore.generated.model;


import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Task type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Tasks")
public final class Task implements Model {
  public static final QueryField ID = field("id");
  public static final QueryField USERNAME = field("username");
  public static final QueryField MONDAY = field("monday");
  public static final QueryField TUESDAY = field("tuesday");
  public static final QueryField WEDNESDAY = field("wednesday");
  public static final QueryField THURSDAY = field("thursday");
  public static final QueryField FRIDAY = field("friday");
  public static final QueryField SATURDAY = field("saturday");
  public static final QueryField SUNDAY = field("sunday");
  public static final QueryField FIFTEEN = field("fifteen");
  public static final QueryField TWENTYFIVE = field("twentyfive");
  public static final QueryField THIRTYFIVE = field("thirtyfive");
  public static final QueryField FORTYFIVE = field("fortyfive");
  public static final QueryField MUSCLE = field("muscle");
  public static final QueryField SLIM = field("slim");
  public static final QueryField FIT = field("fit");
  public static final QueryField RESTORATION = field("restoration");
  public static final QueryField INTENSITY = field("intensity");
  public static final QueryField WAIST = field("waist");
  public static final QueryField ARMS = field("arms");
  public static final QueryField LEGS = field("legs");
  public static final QueryField HIP = field("hip");
  public static final QueryField SHOULDER = field("shoulder");
  public static final QueryField CHEST = field("chest");
  public static final QueryField BACK = field("back");
  public static final QueryField NECK = field("neck");
  public static final QueryField WHOLE = field("whole");
  public static final QueryField ABDOMEN = field("abdomen");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String username;
  private final @ModelField(targetType="String") String monday;
  private final @ModelField(targetType="String") String tuesday;
  private final @ModelField(targetType="String") String wednesday;
  private final @ModelField(targetType="String") String thursday;
  private final @ModelField(targetType="String") String friday;
  private final @ModelField(targetType="String") String saturday;
  private final @ModelField(targetType="String") String sunday;
  private final @ModelField(targetType="String") String fifteen;
  private final @ModelField(targetType="String") String twentyfive;
  private final @ModelField(targetType="String") String thirtyfive;
  private final @ModelField(targetType="String") String fortyfive;
  private final @ModelField(targetType="String") String muscle;
  private final @ModelField(targetType="String") String slim;
  private final @ModelField(targetType="String") String fit;
  private final @ModelField(targetType="String") String restoration;
  private final @ModelField(targetType="String") String intensity;
  private final @ModelField(targetType="String") String waist;
  private final @ModelField(targetType="String") String arms;
  private final @ModelField(targetType="String") String legs;
  private final @ModelField(targetType="String") String hip;
  private final @ModelField(targetType="String") String shoulder;
  private final @ModelField(targetType="String") String chest;
  private final @ModelField(targetType="String") String back;
  private final @ModelField(targetType="String") String neck;
  private final @ModelField(targetType="String") String whole;
  private final @ModelField(targetType="String") String abdomen;
  public String getId() {
      return id;
  }
  
  public String getUsername() {
      return username;
  }
  
  public String getMonday() {
      return monday;
  }
  
  public String getTuesday() {
      return tuesday;
  }
  
  public String getWednesday() {
      return wednesday;
  }
  
  public String getThursday() {
      return thursday;
  }
  
  public String getFriday() {
      return friday;
  }
  
  public String getSaturday() {
      return saturday;
  }
  
  public String getSunday() {
      return sunday;
  }
  
  public String getFifteen() {
      return fifteen;
  }
  
  public String getTwentyfive() {
      return twentyfive;
  }
  
  public String getThirtyfive() {
      return thirtyfive;
  }
  
  public String getFortyfive() {
      return fortyfive;
  }
  
  public String getMuscle() {
      return muscle;
  }
  
  public String getSlim() {
      return slim;
  }
  
  public String getFit() {
      return fit;
  }
  
  public String getRestoration() {
      return restoration;
  }
  
  public String getIntensity() {
      return intensity;
  }
  
  public String getWaist() {
      return waist;
  }
  
  public String getArms() {
      return arms;
  }
  
  public String getLegs() {
      return legs;
  }
  
  public String getHip() {
      return hip;
  }
  
  public String getShoulder() {
      return shoulder;
  }
  
  public String getChest() {
      return chest;
  }
  
  public String getBack() {
      return back;
  }
  
  public String getNeck() {
      return neck;
  }
  
  public String getWhole() {
      return whole;
  }
  
  public String getAbdomen() {
      return abdomen;
  }
  
  private Task(String id, String username, String monday, String tuesday, String wednesday, String thursday, String friday, String saturday, String sunday, String fifteen, String twentyfive, String thirtyfive, String fortyfive, String muscle, String slim, String fit, String restoration, String intensity, String waist, String arms, String legs, String hip, String shoulder, String chest, String back, String neck, String whole, String abdomen) {
    this.id = id;
    this.username = username;
    this.monday = monday;
    this.tuesday = tuesday;
    this.wednesday = wednesday;
    this.thursday = thursday;
    this.friday = friday;
    this.saturday = saturday;
    this.sunday = sunday;
    this.fifteen = fifteen;
    this.twentyfive = twentyfive;
    this.thirtyfive = thirtyfive;
    this.fortyfive = fortyfive;
    this.muscle = muscle;
    this.slim = slim;
    this.fit = fit;
    this.restoration = restoration;
    this.intensity = intensity;
    this.waist = waist;
    this.arms = arms;
    this.legs = legs;
    this.hip = hip;
    this.shoulder = shoulder;
    this.chest = chest;
    this.back = back;
    this.neck = neck;
    this.whole = whole;
    this.abdomen = abdomen;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Task task = (Task) obj;
      return ObjectsCompat.equals(getId(), task.getId()) &&
              ObjectsCompat.equals(getUsername(), task.getUsername()) &&
              ObjectsCompat.equals(getMonday(), task.getMonday()) &&
              ObjectsCompat.equals(getTuesday(), task.getTuesday()) &&
              ObjectsCompat.equals(getWednesday(), task.getWednesday()) &&
              ObjectsCompat.equals(getThursday(), task.getThursday()) &&
              ObjectsCompat.equals(getFriday(), task.getFriday()) &&
              ObjectsCompat.equals(getSaturday(), task.getSaturday()) &&
              ObjectsCompat.equals(getSunday(), task.getSunday()) &&
              ObjectsCompat.equals(getFifteen(), task.getFifteen()) &&
              ObjectsCompat.equals(getTwentyfive(), task.getTwentyfive()) &&
              ObjectsCompat.equals(getThirtyfive(), task.getThirtyfive()) &&
              ObjectsCompat.equals(getFortyfive(), task.getFortyfive()) &&
              ObjectsCompat.equals(getMuscle(), task.getMuscle()) &&
              ObjectsCompat.equals(getSlim(), task.getSlim()) &&
              ObjectsCompat.equals(getFit(), task.getFit()) &&
              ObjectsCompat.equals(getRestoration(), task.getRestoration()) &&
              ObjectsCompat.equals(getIntensity(), task.getIntensity()) &&
              ObjectsCompat.equals(getWaist(), task.getWaist()) &&
              ObjectsCompat.equals(getArms(), task.getArms()) &&
              ObjectsCompat.equals(getLegs(), task.getLegs()) &&
              ObjectsCompat.equals(getHip(), task.getHip()) &&
              ObjectsCompat.equals(getShoulder(), task.getShoulder()) &&
              ObjectsCompat.equals(getChest(), task.getChest()) &&
              ObjectsCompat.equals(getBack(), task.getBack()) &&
              ObjectsCompat.equals(getNeck(), task.getNeck()) &&
              ObjectsCompat.equals(getWhole(), task.getWhole()) &&
              ObjectsCompat.equals(getAbdomen(), task.getAbdomen());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getUsername())
      .append(getMonday())
      .append(getTuesday())
      .append(getWednesday())
      .append(getThursday())
      .append(getFriday())
      .append(getSaturday())
      .append(getSunday())
      .append(getFifteen())
      .append(getTwentyfive())
      .append(getThirtyfive())
      .append(getFortyfive())
      .append(getMuscle())
      .append(getSlim())
      .append(getFit())
      .append(getRestoration())
      .append(getIntensity())
      .append(getWaist())
      .append(getArms())
      .append(getLegs())
      .append(getHip())
      .append(getShoulder())
      .append(getChest())
      .append(getBack())
      .append(getNeck())
      .append(getWhole())
      .append(getAbdomen())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Task {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("username=" + String.valueOf(getUsername()) + ", ")
      .append("monday=" + String.valueOf(getMonday()) + ", ")
      .append("tuesday=" + String.valueOf(getTuesday()) + ", ")
      .append("wednesday=" + String.valueOf(getWednesday()) + ", ")
      .append("thursday=" + String.valueOf(getThursday()) + ", ")
      .append("friday=" + String.valueOf(getFriday()) + ", ")
      .append("saturday=" + String.valueOf(getSaturday()) + ", ")
      .append("sunday=" + String.valueOf(getSunday()) + ", ")
      .append("fifteen=" + String.valueOf(getFifteen()) + ", ")
      .append("twentyfive=" + String.valueOf(getTwentyfive()) + ", ")
      .append("thirtyfive=" + String.valueOf(getThirtyfive()) + ", ")
      .append("fortyfive=" + String.valueOf(getFortyfive()) + ", ")
      .append("muscle=" + String.valueOf(getMuscle()) + ", ")
      .append("slim=" + String.valueOf(getSlim()) + ", ")
      .append("fit=" + String.valueOf(getFit()) + ", ")
      .append("restoration=" + String.valueOf(getRestoration()) + ", ")
      .append("intensity=" + String.valueOf(getIntensity()) + ", ")
      .append("waist=" + String.valueOf(getWaist()) + ", ")
      .append("arms=" + String.valueOf(getArms()) + ", ")
      .append("legs=" + String.valueOf(getLegs()) + ", ")
      .append("hip=" + String.valueOf(getHip()) + ", ")
      .append("shoulder=" + String.valueOf(getShoulder()) + ", ")
      .append("chest=" + String.valueOf(getChest()) + ", ")
      .append("back=" + String.valueOf(getBack()) + ", ")
      .append("neck=" + String.valueOf(getNeck()) + ", ")
      .append("whole=" + String.valueOf(getWhole()) + ", ")
      .append("abdomen=" + String.valueOf(getAbdomen()))
      .append("}")
      .toString();
  }
  
  public static UsernameStep builder() {
      return new Builder();
  }
  
  /** 
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   * @throws IllegalArgumentException Checks that ID is in the proper format
   */
  public static Task justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new Task(
      id,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      username,
      monday,
      tuesday,
      wednesday,
      thursday,
      friday,
      saturday,
      sunday,
      fifteen,
      twentyfive,
      thirtyfive,
      fortyfive,
      muscle,
      slim,
      fit,
      restoration,
      intensity,
      waist,
      arms,
      legs,
      hip,
      shoulder,
      chest,
      back,
      neck,
      whole,
      abdomen);
  }
  public interface UsernameStep {
    BuildStep username(String username);
  }
  

  public interface BuildStep {
    Task build();
    BuildStep id(String id) throws IllegalArgumentException;
    BuildStep monday(String monday);
    BuildStep tuesday(String tuesday);
    BuildStep wednesday(String wednesday);
    BuildStep thursday(String thursday);
    BuildStep friday(String friday);
    BuildStep saturday(String saturday);
    BuildStep sunday(String sunday);
    BuildStep fifteen(String fifteen);
    BuildStep twentyfive(String twentyfive);
    BuildStep thirtyfive(String thirtyfive);
    BuildStep fortyfive(String fortyfive);
    BuildStep muscle(String muscle);
    BuildStep slim(String slim);
    BuildStep fit(String fit);
    BuildStep restoration(String restoration);
    BuildStep intensity(String intensity);
    BuildStep waist(String waist);
    BuildStep arms(String arms);
    BuildStep legs(String legs);
    BuildStep hip(String hip);
    BuildStep shoulder(String shoulder);
    BuildStep chest(String chest);
    BuildStep back(String back);
    BuildStep neck(String neck);
    BuildStep whole(String whole);
    BuildStep abdomen(String abdomen);
  }
  

  public static class Builder implements UsernameStep, BuildStep {
    private String id;
    private String username;
    private String monday;
    private String tuesday;
    private String wednesday;
    private String thursday;
    private String friday;
    private String saturday;
    private String sunday;
    private String fifteen;
    private String twentyfive;
    private String thirtyfive;
    private String fortyfive;
    private String muscle;
    private String slim;
    private String fit;
    private String restoration;
    private String intensity;
    private String waist;
    private String arms;
    private String legs;
    private String hip;
    private String shoulder;
    private String chest;
    private String back;
    private String neck;
    private String whole;
    private String abdomen;
    @Override
     public Task build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Task(
          id,
          username,
          monday,
          tuesday,
          wednesday,
          thursday,
          friday,
          saturday,
          sunday,
          fifteen,
          twentyfive,
          thirtyfive,
          fortyfive,
          muscle,
          slim,
          fit,
          restoration,
          intensity,
          waist,
          arms,
          legs,
          hip,
          shoulder,
          chest,
          back,
          neck,
          whole,
          abdomen);
    }
    
    @Override
     public BuildStep username(String username) {
        Objects.requireNonNull(username);
        this.username = username;
        return this;
    }
    
    @Override
     public BuildStep monday(String monday) {
        this.monday = monday;
        return this;
    }
    
    @Override
     public BuildStep tuesday(String tuesday) {
        this.tuesday = tuesday;
        return this;
    }
    
    @Override
     public BuildStep wednesday(String wednesday) {
        this.wednesday = wednesday;
        return this;
    }
    
    @Override
     public BuildStep thursday(String thursday) {
        this.thursday = thursday;
        return this;
    }
    
    @Override
     public BuildStep friday(String friday) {
        this.friday = friday;
        return this;
    }
    
    @Override
     public BuildStep saturday(String saturday) {
        this.saturday = saturday;
        return this;
    }
    
    @Override
     public BuildStep sunday(String sunday) {
        this.sunday = sunday;
        return this;
    }
    
    @Override
     public BuildStep fifteen(String fifteen) {
        this.fifteen = fifteen;
        return this;
    }
    
    @Override
     public BuildStep twentyfive(String twentyfive) {
        this.twentyfive = twentyfive;
        return this;
    }
    
    @Override
     public BuildStep thirtyfive(String thirtyfive) {
        this.thirtyfive = thirtyfive;
        return this;
    }
    
    @Override
     public BuildStep fortyfive(String fortyfive) {
        this.fortyfive = fortyfive;
        return this;
    }
    
    @Override
     public BuildStep muscle(String muscle) {
        this.muscle = muscle;
        return this;
    }
    
    @Override
     public BuildStep slim(String slim) {
        this.slim = slim;
        return this;
    }
    
    @Override
     public BuildStep fit(String fit) {
        this.fit = fit;
        return this;
    }
    
    @Override
     public BuildStep restoration(String restoration) {
        this.restoration = restoration;
        return this;
    }
    
    @Override
     public BuildStep intensity(String intensity) {
        this.intensity = intensity;
        return this;
    }
    
    @Override
     public BuildStep waist(String waist) {
        this.waist = waist;
        return this;
    }
    
    @Override
     public BuildStep arms(String arms) {
        this.arms = arms;
        return this;
    }
    
    @Override
     public BuildStep legs(String legs) {
        this.legs = legs;
        return this;
    }
    
    @Override
     public BuildStep hip(String hip) {
        this.hip = hip;
        return this;
    }
    
    @Override
     public BuildStep shoulder(String shoulder) {
        this.shoulder = shoulder;
        return this;
    }
    
    @Override
     public BuildStep chest(String chest) {
        this.chest = chest;
        return this;
    }
    
    @Override
     public BuildStep back(String back) {
        this.back = back;
        return this;
    }
    
    @Override
     public BuildStep neck(String neck) {
        this.neck = neck;
        return this;
    }
    
    @Override
     public BuildStep whole(String whole) {
        this.whole = whole;
        return this;
    }
    
    @Override
     public BuildStep abdomen(String abdomen) {
        this.abdomen = abdomen;
        return this;
    }
    
    /** 
     * WARNING: Do not set ID when creating a new object. Leave this blank and one will be auto generated for you.
     * This should only be set when referring to an already existing object.
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     * @throws IllegalArgumentException Checks that ID is in the proper format
     */
    public BuildStep id(String id) throws IllegalArgumentException {
        this.id = id;
        
        try {
            UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
        } catch (Exception exception) {
          throw new IllegalArgumentException("Model IDs must be unique in the format of UUID.",
                    exception);
        }
        
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, String username, String monday, String tuesday, String wednesday, String thursday, String friday, String saturday, String sunday, String fifteen, String twentyfive, String thirtyfive, String fortyfive, String muscle, String slim, String fit, String restoration, String intensity, String waist, String arms, String legs, String hip, String shoulder, String chest, String back, String neck, String whole, String abdomen) {
      super.id(id);
      super.username(username)
        .monday(monday)
        .tuesday(tuesday)
        .wednesday(wednesday)
        .thursday(thursday)
        .friday(friday)
        .saturday(saturday)
        .sunday(sunday)
        .fifteen(fifteen)
        .twentyfive(twentyfive)
        .thirtyfive(thirtyfive)
        .fortyfive(fortyfive)
        .muscle(muscle)
        .slim(slim)
        .fit(fit)
        .restoration(restoration)
        .intensity(intensity)
        .waist(waist)
        .arms(arms)
        .legs(legs)
        .hip(hip)
        .shoulder(shoulder)
        .chest(chest)
        .back(back)
        .neck(neck)
        .whole(whole)
        .abdomen(abdomen);
    }
    
    @Override
     public CopyOfBuilder username(String username) {
      return (CopyOfBuilder) super.username(username);
    }
    
    @Override
     public CopyOfBuilder monday(String monday) {
      return (CopyOfBuilder) super.monday(monday);
    }
    
    @Override
     public CopyOfBuilder tuesday(String tuesday) {
      return (CopyOfBuilder) super.tuesday(tuesday);
    }
    
    @Override
     public CopyOfBuilder wednesday(String wednesday) {
      return (CopyOfBuilder) super.wednesday(wednesday);
    }
    
    @Override
     public CopyOfBuilder thursday(String thursday) {
      return (CopyOfBuilder) super.thursday(thursday);
    }
    
    @Override
     public CopyOfBuilder friday(String friday) {
      return (CopyOfBuilder) super.friday(friday);
    }
    
    @Override
     public CopyOfBuilder saturday(String saturday) {
      return (CopyOfBuilder) super.saturday(saturday);
    }
    
    @Override
     public CopyOfBuilder sunday(String sunday) {
      return (CopyOfBuilder) super.sunday(sunday);
    }
    
    @Override
     public CopyOfBuilder fifteen(String fifteen) {
      return (CopyOfBuilder) super.fifteen(fifteen);
    }
    
    @Override
     public CopyOfBuilder twentyfive(String twentyfive) {
      return (CopyOfBuilder) super.twentyfive(twentyfive);
    }
    
    @Override
     public CopyOfBuilder thirtyfive(String thirtyfive) {
      return (CopyOfBuilder) super.thirtyfive(thirtyfive);
    }
    
    @Override
     public CopyOfBuilder fortyfive(String fortyfive) {
      return (CopyOfBuilder) super.fortyfive(fortyfive);
    }
    
    @Override
     public CopyOfBuilder muscle(String muscle) {
      return (CopyOfBuilder) super.muscle(muscle);
    }
    
    @Override
     public CopyOfBuilder slim(String slim) {
      return (CopyOfBuilder) super.slim(slim);
    }
    
    @Override
     public CopyOfBuilder fit(String fit) {
      return (CopyOfBuilder) super.fit(fit);
    }
    
    @Override
     public CopyOfBuilder restoration(String restoration) {
      return (CopyOfBuilder) super.restoration(restoration);
    }
    
    @Override
     public CopyOfBuilder intensity(String intensity) {
      return (CopyOfBuilder) super.intensity(intensity);
    }
    
    @Override
     public CopyOfBuilder waist(String waist) {
      return (CopyOfBuilder) super.waist(waist);
    }
    
    @Override
     public CopyOfBuilder arms(String arms) {
      return (CopyOfBuilder) super.arms(arms);
    }
    
    @Override
     public CopyOfBuilder legs(String legs) {
      return (CopyOfBuilder) super.legs(legs);
    }
    
    @Override
     public CopyOfBuilder hip(String hip) {
      return (CopyOfBuilder) super.hip(hip);
    }
    
    @Override
     public CopyOfBuilder shoulder(String shoulder) {
      return (CopyOfBuilder) super.shoulder(shoulder);
    }
    
    @Override
     public CopyOfBuilder chest(String chest) {
      return (CopyOfBuilder) super.chest(chest);
    }
    
    @Override
     public CopyOfBuilder back(String back) {
      return (CopyOfBuilder) super.back(back);
    }
    
    @Override
     public CopyOfBuilder neck(String neck) {
      return (CopyOfBuilder) super.neck(neck);
    }
    
    @Override
     public CopyOfBuilder whole(String whole) {
      return (CopyOfBuilder) super.whole(whole);
    }
    
    @Override
     public CopyOfBuilder abdomen(String abdomen) {
      return (CopyOfBuilder) super.abdomen(abdomen);
    }
  }
  
}
