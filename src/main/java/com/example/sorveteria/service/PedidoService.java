package com.example.sorveteria.service;

import com.example.sorveteria.dto.PedidoDTO;
import com.example.sorveteria.model.ItemPedido;
import com.example.sorveteria.model.Pedido;
import com.example.sorveteria.model.Sorvete;
import com.example.sorveteria.repository.PedidoRepository;
import com.example.sorveteria.repository.SorveteRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepo;
    private final SorveteRepository sorveteRepo;

    public PedidoService(PedidoRepository pedidoRepo, SorveteRepository sorveteRepo) {
        this.pedidoRepo = pedidoRepo;
        this.sorveteRepo = sorveteRepo;
    }

    public List<Pedido> listar() { return pedidoRepo.findAll(); }
    public Optional<Pedido> buscar(Long id) { return pedidoRepo.findById(id); }
    public void deletar(Long id) { pedidoRepo.deleteById(id); }

    public Pedido criar(PedidoDTO dto) {
        Pedido p = new Pedido();
        p.setCliente(dto.getCliente());
        p.setCriadoEm(LocalDateTime.now());

        double total = 0.0;
        for (PedidoDTO.ItemDTO i : dto.getItens()) {
            Sorvete s = sorveteRepo.findById(i.getSorveteId()).orElseThrow();
            ItemPedido item = new ItemPedido();
            item.setPedido(p);
            item.setSorvete(s);
            item.setQuantidade(i.getQuantidade());
            double subtotal = s.getPreco() * i.getQuantidade();
            item.setSubtotal(subtotal);
            p.getItens().add(item);
            total += subtotal;
        }
        p.setTotal(total);
        return pedidoRepo.save(p);
    }
}
