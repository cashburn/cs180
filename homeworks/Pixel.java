public class Pixel {
    private int value;
   
    public Pixel(int value) {
        this.value = value;
    }
    
    public int getRed() {
        return (value >> 16) & 255;
    }
    
    public int getGreen() {
        return (value >> 8) & 255;
    }
    
    public int getBlue() {
        return value & 255;
    }
    
    public void setRed(int red) {
        red = red & 0xFF;
        int mask = ~ (255 << 16);
        value = (red << 16) | (mask & value);
    }
    public void setGreen(int green) {
        green = green & 0xFF;
        int mask = ~ (255 << 8);
        value = (green << 8) | (mask & value);
    }
    public void setBlue(int blue) {
        blue = blue & 0xFF;
        int mask = ~ (255);
        value = blue | (mask & value);
    }
}