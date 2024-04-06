package Model;

public class Toolcard {
    private int id;
    private int seqnr;
    private String name;
    private String description;
    public Toolcard(int id, int seqnr, String name, String description) {
        this.id = id;
        this.seqnr = seqnr;
        this.name = name;
        this.description = description;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setSeqnr(int seqnr) {
        this.seqnr = seqnr;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public int getSeqnr() {
        return seqnr;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
