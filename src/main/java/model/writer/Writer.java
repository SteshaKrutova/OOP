package family_tree.writer;

import java.io.Serializable;

public interface Writer {
    void write(Serializable human);
    Object read();
}
