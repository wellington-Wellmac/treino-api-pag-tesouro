package com.treinamento.apipagtesouro.repository;
import java.util.Date;
import java.util.List;

import com.treinamento.apipagtesouro.entity.PagTesouroPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public class PagTesouroPagamentoRepository extends JpaRepository <PagTesouroPagamento, Integer> {

    @Query("SELECT pag FROM PagTesouroPagamento pag WHERE pag.idPagamento = :ID_PAGAMENTO ORDER BY pag.dataSituacao")
    List<PagTesouroPagamento> findByIdPagamentoOrderByDataSituacao(@Param("ID_PAGAMENTO") String idPagamento);

    @Query(value = "SELECT pag.dataCriacao FROM PagTesouroPagamento pag WHERE pag.idPagamento = :ID_PAGAMENTO GROUP BY pag.dataCriacao")
    Date findDataCriacaoByIdPagamento(@Param("ID_PAGAMENTO") String idPagamento);

    @Query(value = "SELECT pag.dataVencimento FROM PagTesouroPagamento pag WHERE pag.idPagamento = :ID_PAGAMENTO GROUP BY pag.dataVencimento")
    Date findDataVencimentoByIdPagamento(@Param("ID_PAGAMENTO") String idPagamento);

    @Query("SELECT pag FROM PagTesouroPagamento pag WHERE pag.idPagamento = :ID_PAGAMENTO AND pag.descricaoSituacao = :ST_PAGAMENTO")
    PagTesouroPagamento findPagamentoByIdPagamentoAndSituacao(@Param("ID_PAGAMENTO") String idPagamento, @Param("ST_PAGAMENTO") String situacao);

}
