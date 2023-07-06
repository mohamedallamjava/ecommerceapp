package com.ecomerce.app.ecommerceapp.hateoas;
import com.ecomerce.app.ecommerceapp.entity.CartEntity;
import com.ecomerce.app.ecommerceapp.entity.ItemEntity;
import com.ecomerce.app.ecommerceapp.model.Cart;
import com.ecomerce.app.ecommerceapp.model.Item;
import com.ecomerce.app.ecommerceapp.service.ItemService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.reactive.ReactiveRepresentationModelAssembler;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component

public class CartRepresentaionModelAssembler implements ReactiveRepresentationModelAssembler<CartEntity, Cart> ,HateoasSupport {
    private ItemService itemService;
    private static String serverUri= null;
private String getServerUri(@Nullable ServerWebExchange exchange) {
    if (Strings.isBlank(serverUri))
    {
        serverUri=getUriCompnenetBuilder(exchange).toUriString();
    }
    return serverUri;
       }

    @Override
    public Mono<Cart> toModel(CartEntity entity, ServerWebExchange exchange) {
        return Mono.just(entityToModel(entity,exchange));
    }
public Cart entityToModel(CartEntity entity,ServerWebExchange exchange)
 {
Cart resource=new Cart();
 if (Objects.isNull(entity))
     return resource;
resource.id(entity.getId().toString()).customerId(entity.getUser().getId().toString()).items(itemsFromEntities(entity.getItems()));
String serverUri=getServerUri(exchange);
resource.add(Link.of(String.format("%s/api/v1/carts/%s",serverUri,entity.getId())).withSelfRel());
return resource;
 }

    private List<Item> itemsFromEntities(List<ItemEntity> items) {
  return items.stream().map(i->new Item().id(i.getProduct().toString())
          .unitPrice(i.getPrice())
          .quantity(i.getQuantity())).collect(Collectors.toList());
    }


public Flux<Cart> toListModel(Flux<CartEntity> entities,ServerWebExchange exchange)
{
    if(Objects.isNull(entities)) {
        return Flux.empty();
    }
    return Flux.from(entities.map(e->entityToModel(e,exchange)));
}
}
