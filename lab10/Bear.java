public class Bear extends Animal {
    public Bear(String status) {
        super(status);
    }
    @Override
    public void makeMove(SiteGrid sg) {
        try {
            if (getStatus().equals("ALIVE") && (getSite().getType() == SiteType.WINTERING))
                if (Math.random() < 0.3)
                    die();
        }
        catch (NullPointerException e) {
        }
        if (getStatus().equals("ALIVE"))
            super.makeMove(sg);
    }
    
}