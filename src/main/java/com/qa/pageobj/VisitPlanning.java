package com.qa.pageobj;

public class VisitPlanning {
    private String customername;
    private String phonenumber;
    private String email;
    private String address;
    private String visitdate;
    private String visittime;
    private PurposeOfVisit purposevisit; // Enum type
    private String remarks;

    public VisitPlanning(VisitPlanningBuilder visitplanningbuilder) {
        this.customername = visitplanningbuilder.customername;
        this.phonenumber = visitplanningbuilder.phonenumber;
        this.email = visitplanningbuilder.email;
        this.address = visitplanningbuilder.address;
        this.visitdate = visitplanningbuilder.visitdate;
        this.visittime = visitplanningbuilder.visittime;
        this.purposevisit = visitplanningbuilder.purposevisit;
        this.remarks = visitplanningbuilder.remarks;
    }

    // Getters remain the same
    public String getCustomername() { return customername; }
    public String getPhonenumber() { return phonenumber; }
    public String getEmail() { return email; }
    public String getAddress() { return address; }
    public String getVisitdate() { return visitdate; }
    public String getVisittime() { return visittime; }
    public PurposeOfVisit getPurposevisit() { return purposevisit; }
    public String getRemarks() { return remarks; }

    public static class VisitPlanningBuilder {
        private String customername;
        private String phonenumber;
        private String email;
        private String address;
        private String visitdate;
        private String visittime;
        private PurposeOfVisit purposevisit; // Enum type
        private String remarks;

        public VisitPlanningBuilder setCustomername(String customername) {
            this.customername = customername;
            return this;
        }

        public VisitPlanningBuilder setPhonenumber(String phonenumber) {
            this.phonenumber = phonenumber;
            return this;
        }

        public VisitPlanningBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public VisitPlanningBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public VisitPlanningBuilder setVisitdate(String visitdate) {
            this.visitdate = visitdate;
            return this;
        }

        public VisitPlanningBuilder setVisittime(String visittime) {
            this.visittime = visittime;
            return this;
        }

        public VisitPlanningBuilder setPurposevisit(PurposeOfVisit purposevisit) {
            this.purposevisit = purposevisit;
            return this;
        }

        public VisitPlanningBuilder setRemarks(String remarks) {
            this.remarks = remarks;
            return this;
        }

        public VisitPlanning build() {
            return new VisitPlanning(this);
        }
    }
}
