
package ToDoList;

public class Task implements java.io.Serializable {
    private String name;
    private String description;
    private Boolean isPending;

    public Task(String name, String description, Boolean isPending) {
      this.name = name;
        this.description = description;
        this.isPending = isPending;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getPending() {
        return isPending;
    }

    public void setPending(Boolean pending) {
        isPending = pending;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Task " + name + ", description: " + description + ", Is pending:  " + isPending +"\n";
    }
}
