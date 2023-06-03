package dmit2015.faces;

import dmit2015.restclient.TodoItem;
import dmit2015.restclient.TodoItemMpRestClient;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.json.JsonObject;
import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.omnifaces.util.Messages;
import org.primefaces.PrimeFaces;

import java.io.Serializable;
import java.util.Map;

@Named("currentTodoItemCrudView")
@ViewScoped
public class TodoItemCrudView implements Serializable {

    @Inject
    @RestClient
    private TodoItemMpRestClient _TodoItemMpRestClient;

    @Getter
    private Map<String, TodoItem> TodoItemMap;

    @Getter
    @Setter
    private TodoItem selectedTodoItem;

    @Getter
    @Setter
    private String selectedKey;

    @PostConstruct  // After @Inject is complete
    public void init() {
        try {
            TodoItemMap = _TodoItemMpRestClient.findAll();
        } catch (Exception ex) {
            Messages.addGlobalError(ex.getMessage());
        }
    }

    public void onOpenNew() {
        selectedTodoItem = new TodoItem();
    }

    public void onSave() {
        if (selectedKey == null) {
            try {
                JsonObject responseBody = _TodoItemMpRestClient.create(selectedTodoItem);
                String documentKey = responseBody.getString("name");
                Messages.addGlobalInfo("Create was successful. {0}", documentKey);
                TodoItemMap = _TodoItemMpRestClient.findAll();
            } catch (Exception e) {
                e.printStackTrace();
                Messages.addGlobalError("Create was not successful. {0}", e.getMessage());
            }
        } else {
            try {
                _TodoItemMpRestClient.update(selectedKey, selectedTodoItem);
                Messages.addFlashGlobalInfo("Update was successful.");
            } catch (Exception e) {
                e.printStackTrace();
                Messages.addGlobalError("Update was not successful.");
            }
        }

        PrimeFaces.current().executeScript("PF('manageTodoItemDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-TodoItems");
    }

    public void onDelete() {
        try {
            _TodoItemMpRestClient.delete(selectedKey);
            selectedTodoItem = null;
            Messages.addGlobalInfo("Delete was successful.");
            TodoItemMap = _TodoItemMpRestClient.findAll();
            PrimeFaces.current().ajax().update("form:messages", "form:dt-TodoItems");
        } catch (Exception e) {
            e.printStackTrace();
            Messages.addGlobalError("Delete not successful.");
        }
    }

}