package DTO;

import java.io.Serializable;
import java.util.Objects;

public class IDSinhVien_Mon implements Serializable {
    protected int mssv;
    protected String maMon;

    public IDSinhVien_Mon()
    {

    }

    public IDSinhVien_Mon(int mssv, String maMon) {
        this.mssv = mssv;
        this.maMon = maMon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IDSinhVien_Mon)) return false;
        IDSinhVien_Mon that = (IDSinhVien_Mon) o;
        return mssv == that.mssv &&
                Objects.equals(maMon, that.maMon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mssv, maMon);
    }
}
