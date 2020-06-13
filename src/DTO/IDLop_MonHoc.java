package DTO;

import java.io.Serializable;
import java.util.Objects;

public class IDLop_MonHoc implements Serializable {
    protected String tenLop;
    protected String maMon;

    public IDLop_MonHoc()
    {

    }

    public IDLop_MonHoc(String tenLop, String maMon) {
        this.tenLop = tenLop;
        this.maMon = maMon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IDLop_MonHoc)) return false;
        IDLop_MonHoc that = (IDLop_MonHoc) o;
        return tenLop.equals(that.tenLop) &&
                maMon.equals(that.maMon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tenLop, maMon);
    }


}
