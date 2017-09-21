package com.rajbir.core.repository;

/**
 * Created by Sony on 12-09-2017.
 */
public class GroupRepositoryImpl {

//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    public BigDecimal findConvenienceFeereceivedFromPayuForOrderId(String accountId, String orderId) {
//        String query = "Select coalesce(sum(p.extraCharge),0) from paymentTransaction p " +
//                "where p.orderId= :orderId " +
//                "AND p.accountIdFrom = :accountId " +
//                "AND (" +
//                "   (vendor = 'PAYU' AND paymentMode = 'PG' AND paymentTransactionStatus = 'REALIZED' ) " +
//                "or (paymentMode = 'COD' and (paymentTransactionStatus = 'REALIZED' or paymentTransactionStatus = 'PENDING_APPROVAL')))";
//        Query nativeQuery = entityManager.createNativeQuery(query);
//        nativeQuery.setParameter("orderId", orderId);
//        nativeQuery.setParameter("accountId", accountId);
//        Object singleResult = nativeQuery.getSingleResult();
//        if (singleResult instanceof Double) {
//            return new BigDecimal((double) singleResult);
//        }
//        if (singleResult instanceof BigDecimal) {
//            return (BigDecimal) singleResult;
//        }
//        return ZERO;
//    }

}
