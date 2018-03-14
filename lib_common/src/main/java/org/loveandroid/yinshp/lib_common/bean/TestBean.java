package org.loveandroid.yinshp.lib_common.bean;

import java.util.List;

/**
 * =========================================
 * Author : yinshengpan
 * Email : yinshp0423@163.com
 * Created date :　2018/3/14 15:04
 * Describe :
 * ==========================================
 */
public class TestBean {


    /**
     * code : 1
     * message : [{"advmsg_id":"1","advmsg_cost_id":"25","costtype_id":"1","advmsg_type_id":"2","advmsg_user_id":"33158","advmsg_seat_id":"9","advmsg_mold_id":"1","advmsg_content":"1112222哈哈哈哈哈哈哈","advmsg_master":null,"advmsg_images":null,"advmsg_date":"2018-03-08 15:45:32","advmsg_verify_date":"0000-00-00 00:00:00","advmsg_address":"中国浙江省嘉兴市南湖区昌盛南路","advmsg_reason":null,"advmsg_cost":"按固定日期扣费，120元/天","advmsg_seat_number":"1","advmsg_user_phone":"18258324021","advmsg_overtime":null,"advmsg_answ":"1","advmsg_state":"0","typeSubName":"即时消息焦点推广位1","typeSubId":"9","adv_cost_money":"120.00","temp":"按固定日期扣费","Adv_time_id":"2921"}]
     * refuseMessage : [{"write_id":"2","write_type":"推广拒绝","write_title":"就是拒绝你的推广","write_content":""}]
     * down : 1
     * time : null
     */

    private int code;
    private String down;
    private Object time;
    private List<MessageBean> message;
    private List<RefuseMessageBean> refuseMessage;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDown() {
        return down;
    }

    public void setDown(String down) {
        this.down = down;
    }

    public Object getTime() {
        return time;
    }

    public void setTime(Object time) {
        this.time = time;
    }

    public List<MessageBean> getMessage() {
        return message;
    }

    public void setMessage(List<MessageBean> message) {
        this.message = message;
    }

    public List<RefuseMessageBean> getRefuseMessage() {
        return refuseMessage;
    }

    public void setRefuseMessage(List<RefuseMessageBean> refuseMessage) {
        this.refuseMessage = refuseMessage;
    }

    public static class MessageBean {
        /**
         * advmsg_id : 1
         * advmsg_cost_id : 25
         * costtype_id : 1
         * advmsg_type_id : 2
         * advmsg_user_id : 33158
         * advmsg_seat_id : 9
         * advmsg_mold_id : 1
         * advmsg_content : 1112222哈哈哈哈哈哈哈
         * advmsg_master : null
         * advmsg_images : null
         * advmsg_date : 2018-03-08 15:45:32
         * advmsg_verify_date : 0000-00-00 00:00:00
         * advmsg_address : 中国浙江省嘉兴市南湖区昌盛南路
         * advmsg_reason : null
         * advmsg_cost : 按固定日期扣费，120元/天
         * advmsg_seat_number : 1
         * advmsg_user_phone : 18258324021
         * advmsg_overtime : null
         * advmsg_answ : 1
         * advmsg_state : 0
         * typeSubName : 即时消息焦点推广位1
         * typeSubId : 9
         * adv_cost_money : 120.00
         * temp : 按固定日期扣费
         * Adv_time_id : 2921
         */

        private String advmsg_id;
        private String advmsg_cost_id;
        private String costtype_id;
        private String advmsg_type_id;
        private String advmsg_user_id;
        private String advmsg_seat_id;
        private String advmsg_mold_id;
        private String advmsg_content;
        private Object advmsg_master;
        private Object advmsg_images;
        private String advmsg_date;
        private String advmsg_verify_date;
        private String advmsg_address;
        private Object advmsg_reason;
        private String advmsg_cost;
        private String advmsg_seat_number;
        private String advmsg_user_phone;
        private Object advmsg_overtime;
        private String advmsg_answ;
        private String advmsg_state;
        private String typeSubName;
        private String typeSubId;
        private String adv_cost_money;
        private String temp;
        private String Adv_time_id;

        public String getAdvmsg_id() {
            return advmsg_id;
        }

        public void setAdvmsg_id(String advmsg_id) {
            this.advmsg_id = advmsg_id;
        }

        public String getAdvmsg_cost_id() {
            return advmsg_cost_id;
        }

        public void setAdvmsg_cost_id(String advmsg_cost_id) {
            this.advmsg_cost_id = advmsg_cost_id;
        }

        public String getCosttype_id() {
            return costtype_id;
        }

        public void setCosttype_id(String costtype_id) {
            this.costtype_id = costtype_id;
        }

        public String getAdvmsg_type_id() {
            return advmsg_type_id;
        }

        public void setAdvmsg_type_id(String advmsg_type_id) {
            this.advmsg_type_id = advmsg_type_id;
        }

        public String getAdvmsg_user_id() {
            return advmsg_user_id;
        }

        public void setAdvmsg_user_id(String advmsg_user_id) {
            this.advmsg_user_id = advmsg_user_id;
        }

        public String getAdvmsg_seat_id() {
            return advmsg_seat_id;
        }

        public void setAdvmsg_seat_id(String advmsg_seat_id) {
            this.advmsg_seat_id = advmsg_seat_id;
        }

        public String getAdvmsg_mold_id() {
            return advmsg_mold_id;
        }

        public void setAdvmsg_mold_id(String advmsg_mold_id) {
            this.advmsg_mold_id = advmsg_mold_id;
        }

        public String getAdvmsg_content() {
            return advmsg_content;
        }

        public void setAdvmsg_content(String advmsg_content) {
            this.advmsg_content = advmsg_content;
        }

        public Object getAdvmsg_master() {
            return advmsg_master;
        }

        public void setAdvmsg_master(Object advmsg_master) {
            this.advmsg_master = advmsg_master;
        }

        public Object getAdvmsg_images() {
            return advmsg_images;
        }

        public void setAdvmsg_images(Object advmsg_images) {
            this.advmsg_images = advmsg_images;
        }

        public String getAdvmsg_date() {
            return advmsg_date;
        }

        public void setAdvmsg_date(String advmsg_date) {
            this.advmsg_date = advmsg_date;
        }

        public String getAdvmsg_verify_date() {
            return advmsg_verify_date;
        }

        public void setAdvmsg_verify_date(String advmsg_verify_date) {
            this.advmsg_verify_date = advmsg_verify_date;
        }

        public String getAdvmsg_address() {
            return advmsg_address;
        }

        public void setAdvmsg_address(String advmsg_address) {
            this.advmsg_address = advmsg_address;
        }

        public Object getAdvmsg_reason() {
            return advmsg_reason;
        }

        public void setAdvmsg_reason(Object advmsg_reason) {
            this.advmsg_reason = advmsg_reason;
        }

        public String getAdvmsg_cost() {
            return advmsg_cost;
        }

        public void setAdvmsg_cost(String advmsg_cost) {
            this.advmsg_cost = advmsg_cost;
        }

        public String getAdvmsg_seat_number() {
            return advmsg_seat_number;
        }

        public void setAdvmsg_seat_number(String advmsg_seat_number) {
            this.advmsg_seat_number = advmsg_seat_number;
        }

        public String getAdvmsg_user_phone() {
            return advmsg_user_phone;
        }

        public void setAdvmsg_user_phone(String advmsg_user_phone) {
            this.advmsg_user_phone = advmsg_user_phone;
        }

        public Object getAdvmsg_overtime() {
            return advmsg_overtime;
        }

        public void setAdvmsg_overtime(Object advmsg_overtime) {
            this.advmsg_overtime = advmsg_overtime;
        }

        public String getAdvmsg_answ() {
            return advmsg_answ;
        }

        public void setAdvmsg_answ(String advmsg_answ) {
            this.advmsg_answ = advmsg_answ;
        }

        public String getAdvmsg_state() {
            return advmsg_state;
        }

        public void setAdvmsg_state(String advmsg_state) {
            this.advmsg_state = advmsg_state;
        }

        public String getTypeSubName() {
            return typeSubName;
        }

        public void setTypeSubName(String typeSubName) {
            this.typeSubName = typeSubName;
        }

        public String getTypeSubId() {
            return typeSubId;
        }

        public void setTypeSubId(String typeSubId) {
            this.typeSubId = typeSubId;
        }

        public String getAdv_cost_money() {
            return adv_cost_money;
        }

        public void setAdv_cost_money(String adv_cost_money) {
            this.adv_cost_money = adv_cost_money;
        }

        public String getTemp() {
            return temp;
        }

        public void setTemp(String temp) {
            this.temp = temp;
        }

        public String getAdv_time_id() {
            return Adv_time_id;
        }

        public void setAdv_time_id(String Adv_time_id) {
            this.Adv_time_id = Adv_time_id;
        }
    }

    public static class RefuseMessageBean {
        /**
         * write_id : 2
         * write_type : 推广拒绝
         * write_title : 就是拒绝你的推广
         * write_content :
         */

        private String write_id;
        private String write_type;
        private String write_title;
        private String write_content;

        public String getWrite_id() {
            return write_id;
        }

        public void setWrite_id(String write_id) {
            this.write_id = write_id;
        }

        public String getWrite_type() {
            return write_type;
        }

        public void setWrite_type(String write_type) {
            this.write_type = write_type;
        }

        public String getWrite_title() {
            return write_title;
        }

        public void setWrite_title(String write_title) {
            this.write_title = write_title;
        }

        public String getWrite_content() {
            return write_content;
        }

        public void setWrite_content(String write_content) {
            this.write_content = write_content;
        }
    }
}
