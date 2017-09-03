package substances;

public class material {
    private String name;
    private float weght;
    private int Conductor;

    public material(String name, float weght, int Conductor) {
        this.name = name;
        this.weght = weght;
        this.Conductor = Conductor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeght() {
        return weght;
    }

    public void setWeght(float weght) {
        this.weght = weght;
    }

    public int getConductor() {
        return Conductor;
    }

    public void setConductor(int Conductor) {
        this.Conductor = Conductor;
    }

    @Override
    public String toString () {
        return "Материал: "+this.name+", удельный вес: "+weght+", признак проводимости: "+Conductor;
    }
}
