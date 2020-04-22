package filesystem;

public class Variables {

    String parentFolderId;
    String folderId;
    String isFolder;
    String name;

    public Variables(String parentFolderId, String folderId, String isFolder, String name) {
        this.parentFolderId = parentFolderId;
        this.folderId = folderId;
        this.isFolder = isFolder;
        this.name = name;
    }

    public Variables() {
    }

    public String getParentFolderId() {
        return parentFolderId;
    }

    public void setParentFolderId(String parentFolderId) {
        this.parentFolderId = parentFolderId;
    }

    public String getFolderId() {
        return folderId;
    }

    public void setFolderId(String folderId) {
        this.folderId = folderId;
    }

    public String getIsFolder() {
        return isFolder;
    }

    public void setIsFolder(String isFolder) {
        this.isFolder = isFolder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
