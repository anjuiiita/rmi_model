import java.io.Serializable;

public class GetLocalTime implements Serializable {        
    int time;        
    int valid;
    private static final long serialVersionUID = 1L;
    
    public int getTime() {
        return this.time;
    }

    public int getValid() {
        return this.valid;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setValid(int valid) {
        this.valid = valid;
    }
}