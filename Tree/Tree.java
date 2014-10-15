public class Tree(int serial, double circumference, String species) {

    
    public String describe(int serial, double circumference, String species) {
      this.serial = serial;
      this.circumference = circumference;
      this.species = species;
      String.format("Tree number %d has a circumference of %.2f and is of species %s.", serial, circumference, species)
  }
}  