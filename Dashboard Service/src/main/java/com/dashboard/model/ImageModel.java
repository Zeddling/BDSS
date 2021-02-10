package com.dashboard.model;

public class ImageModel {
    private String name;
    private String type;
    private byte[] bytes;

    public ImageModel() {
    }

    public ImageModel(String name, String type, byte[] bytes) {
        this.name = name;
        this.type = type;
        this.bytes = bytes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
}
