package message_buffer_queue.model;

public class SharedData {
    private Integer id;

    private static int idTemp = 1;

    private String message;

    public Integer getId(){
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SharedData() {
    }

    public SharedData(String message){
        this.id = idTemp++;
        this.message = message;
    }
}
