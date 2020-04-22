/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesystem;

import java.io.*;
import java.util.*;
import javafx.scene.control.TreeItem;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

/**
 *
 * @author NEDL
 */
public class FileSystemModel {

    ArrayList<Variables> folders = new ArrayList<>();

    public FileSystemModel() {
    }

    public void readJSON() throws Exception {

        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("tree.json"));

            JSONArray jsonArray = (JSONArray) obj;

            Iterator iterator = jsonArray.iterator();
            int index = 0;
            while (iterator.hasNext()) {

                JSONObject jsonObject = (JSONObject) jsonArray.get(index);
                String parentFolderId = (String) jsonObject.get("parentFolderId");
                String folderId = (String) jsonObject.get("folderId");
                String isFolder = (String) jsonObject.get("isFolder");
                String name = (String) jsonObject.get("name");

                folders.add(new Variables(parentFolderId, folderId, isFolder, name));

                System.out.println(iterator.next());
                index++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getFolderId(int index) {
        return folders.get(index).folderId;
    }

    public String setFolderId() {
        return String.valueOf(Integer.parseInt(getFolderId(folders.size() - 1)) + 1);
    }

    public TreeItem createTree() {

        TreeItem<Variables> treeItem = new TreeItem<>();

        for (int i = 0; i < folders.size(); i++) {

            Variables Document = folders.get(i);

            if (Document.getParentFolderId() == null) {
                treeItem = new TreeItem<>(folders.get(i));
                treeItem = loadFolder(treeItem, i);
            }
        }
        return treeItem;
    }

    public TreeItem loadFolder(TreeItem<Variables> ti, int index) {

        Variables currentFolder = folders.get(index);

        for (int i = 0; i < folders.size(); i++) {

            Variables document = folders.get(i);

            if (document.parentFolderId != null && document.parentFolderId.equals(currentFolder.folderId)) {
                TreeItem<Variables> child = new TreeItem<>(document);
                ti.getChildren().add(child);

                if (document.isFolder.equals("1")) {
                    loadFolder(child, i);
                }
            }
        }
        return ti;
    }

    public void writeJSON() {

        JSONArray breadcrumb = new JSONArray();

        for (int i = 0; i < folders.size(); i++) {
            JSONObject newFile = new JSONObject();

            Variables documents = folders.get(i);

            newFile.put("parentFolderId", documents.getParentFolderId());
            newFile.put("folderId", documents.getFolderId());
            newFile.put("isFolder", documents.getIsFolder());
            newFile.put("name", documents.getName());
            breadcrumb.add(newFile);
        }

        try (FileWriter file = new FileWriter("treeWrite.json")) {

            file.write(breadcrumb.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delete(Variables document, TreeItem selected) {

        folders.remove(document);
        selected.getParent().getChildren().remove(selected);
    }

    public void create(String name, String parentId) {
        //parentID, folderId, isfolder, name
        folders.add(new Variables(parentId, setFolderId(), "1", name));//for a folder 0 to a document
    }
}
