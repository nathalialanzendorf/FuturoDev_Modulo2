public class Standard {

    
    private DateTime created_date;
   //private integer created_by__contact_id;
    private DateTime updated_date;
   //private integer updated_by__contact_id;
    private boolean deleted;
    private DateTime deleted_date;
    //private integer deleted_by__contact_id;


    public Standard() {
    }

    public DateTime getCreated_date() {
        return created_date;
    }

    public void setCreated_date(DateTime created_date) {
        this.created_date = created_date;
    }

   public DateTime getUpdate_date(){
        return updated_date;
   }

   public void setUpdate_date(DateTime updated_date){
       this.updated_date = updated_date;
   }

   public boolean isDeleted(){
       return deleted;
   }

    public void setDeleted(boolean deleted){
            this.deleted = deleted;
    }

    public DateTime getDeleted_date(){
        return deleted_date;
    }
}