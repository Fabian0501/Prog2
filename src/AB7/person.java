package AB7;

public abstract class person{
    private String name;
    private String vorname;

    public person(String name, String vorname){
        this.name = name;
        this.vorname = vorname;
    }

    public String getName() {
        return name;
    }
    public String getVorname() {
        return vorname;
    }
    public String toString(){
        return name + ", " + vorname;
    }


    @Override
    public boolean equals(Object other) {
        if(! (other instanceof person)){ //
            return false;
        }
        person partner = (person) other;
        return partner.name.equals(this.name) && partner.vorname.equals(this.vorname);
    }
}