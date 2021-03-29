import java.io.Serializable;

public class GetVersion implements Serializable {
    int version;
    private static final long serialVersionUID = 1L;

    GetVersion() {
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
