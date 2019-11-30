package elevencount;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;

public class itemBean implements WritableComparable<itemBean> {
    private  long item_id;//商品id
    private String province;//省份

    @Override
    public int compareTo(itemBean o) {
        if(this.item_id==o.item_id){
            if(this.province==o.province)
                return 0;
            else
                return this.province.compareTo(o.province);
        }
        else if(this.item_id>o.item_id)
            return 1;
        else
            return -1;
    }

    public itemBean() {

        super();
    }

    public itemBean(long item_id, String province) {
        super();

        this.item_id=item_id;
        this.province=province;
    }

    // 序列化
    @Override
    public void write(DataOutput out) throws IOException {

        out.writeLong(item_id);
        out.writeUTF(province);

    }

    // 反序列化
    @Override
    public void readFields(DataInput in) throws IOException {

        item_id = in.readLong();
        province = in.readUTF();
    }

    public long getItem_id() {
        return item_id;
    }

    public void setItem_id(long item_id) {
        this.item_id = item_id;
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String province) {
        this.province = province;
    }


    @Override
    public String toString() {
        return item_id + "\t" + province;
    }

    public void set(long item_id2,String province2){
        item_id=item_id2;
        province=province2;
    }

}
