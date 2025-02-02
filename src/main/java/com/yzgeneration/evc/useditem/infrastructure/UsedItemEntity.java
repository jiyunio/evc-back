package com.yzgeneration.evc.useditem.infrastructure;

import com.yzgeneration.evc.useditem.enums.UsedItemStatus;
import com.yzgeneration.evc.useditem.model.UsedItem;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "used_items")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UsedItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String category;

    private String content;

    private String price;

    @Embedded
    private UsedItemTransactionEntity usedItemTransactionEntity;

    @Enumerated(EnumType.STRING)
    private UsedItemStatus usedItemStatus;

    private int viewCount;

    private int likeCount;

    private int chattingCount;

    private String imagePath;

    private LocalDateTime createdAt;

    public static UsedItemEntity from(UsedItem usedItem) {
        return UsedItemEntity.builder()
                .title(usedItem.getTitle())
                .category(usedItem.getCategory())
                .content(usedItem.getContent())
                .price(usedItem.getPrice())
                .usedItemTransactionEntity(UsedItemTransactionEntity.from(usedItem.getUsedItemTransaction()))
                .usedItemStatus(usedItem.getUsedItemStatus())
                .viewCount(usedItem.getViewCount())
                .likeCount(usedItem.getLikeCount())
                .chattingCount(usedItem.getChattingCount())
                .imagePath(usedItem.getImagePath())
                .createdAt(usedItem.getCreatedAt()).build();
    }

    public UsedItem toModel() {
        return UsedItem.builder()
                .id(id)
                .title(title)
                .category(category)
                .content(content)
                .price(price)
                .usedItemTransaction(usedItemTransactionEntity.toModel())
                .usedItemStatus(usedItemStatus)
                .viewCount(viewCount)
                .likeCount(likeCount)
                .chattingCount(chattingCount)
                .imagePath(imagePath)
                .createdAt(createdAt)
                .build();
    }
}
