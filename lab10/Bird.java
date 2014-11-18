public class Bird extends Animal {
    public Bird(String status) {
        super(status);
    }
    @Override
    public void makeMove(SiteGrid sg) {
        try {
        if (getStatus().equals("ALIVE") && (getSite().getType() == SiteType.WINTERING))
            die();
        }
        catch (NullPointerException e) {
        }
        if (getStatus().equals("ALIVE"))
            super.makeMove(sg);
    }
    
}