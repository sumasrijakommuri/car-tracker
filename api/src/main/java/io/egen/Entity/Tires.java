package io.egen.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Tires {

    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String id;

    private float frontLeft;
    private float frontRight;
    private float rearLeft;
    private float rearRight;

    public Tires(){
        id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getFrontLeft() {
        return frontLeft;
    }

    public void setFrontLeft(float frontLeft) {
        this.frontLeft = frontLeft;
    }

    public float getFrontRight() {
        return frontRight;
    }

    public void setFrontRight(float frontRight) {
        this.frontRight = frontRight;
    }

    public float getRearLeft() {
        return rearLeft;
    }

    public void setRearLeft(float rearLeft) {
        this.rearLeft = rearLeft;
    }

    public float getRearRight() {
        return rearRight;
    }

    public void setRearRight(float rearRight) {
        this.rearRight = rearRight;
    }
}
