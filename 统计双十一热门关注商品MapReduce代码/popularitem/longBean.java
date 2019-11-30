package popularitem;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * longBean数据结构是为了实现倒排
 */
public class longBean implements WritableComparable<longBean> {

    private long focusNum;

    public longBean() {
        super();
    }

    public longBean(long focusNum){
        super();

        this.focusNum=focusNum;
    }

    public long getFocusNum(){
        return focusNum;
    }



    public void setFocusNum(long focusNum){
        this.focusNum=focusNum;
    }



    @Override
    public void readFields(DataInput dataInput) throws IOException {
        focusNum=dataInput.readLong();
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(focusNum);
    }

    @Override
    public int compareTo(longBean o) {
        if(o.focusNum==this.focusNum)
            return 0;
        else if(o.focusNum>this.focusNum)
            return 1;
        else
            return -1;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
