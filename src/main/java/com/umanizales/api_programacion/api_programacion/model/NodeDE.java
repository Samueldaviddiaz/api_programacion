package com.umanizales.api_programacion.api_programacion.model;

import lombok.Data;

@Data
public class NodeDE {
    private Kid data;
    private NodeDE next;
    private NodeDE previous;

    public NodeDE(Kid data) {
        this.data = data;
    }
}