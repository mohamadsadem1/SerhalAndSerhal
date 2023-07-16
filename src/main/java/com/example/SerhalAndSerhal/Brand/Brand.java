package com.example.SerhalAndSerhal.Brand;

import com.example.SerhalAndSerhal.Product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "brands")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "date_created")
    @CreationTimestamp
    private LocalDateTime timeCreated;

    @Column(name = "date_updated")
    @UpdateTimestamp
    private LocalDateTime timeUpdated;

    @OneToMany
    private List<Product> products;

    public String localTimeCreatedToString(){
        if(this.timeCreated!=null)
        return this.timeCreated.toString();
        else
            return null;
    }

    public String localTimeUpdatedToString(){
        if(this.timeUpdated!=null)
        return this.timeUpdated.toString();
        else return null;
    }


}
