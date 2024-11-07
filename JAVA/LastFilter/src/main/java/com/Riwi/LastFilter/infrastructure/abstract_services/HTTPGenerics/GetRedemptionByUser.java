package com.Riwi.LastFilter.infrastructure.abstract_services.HTTPGenerics;

import java.util.List;

public interface GetRedemptionByUser <RS, ID> {
  List<RS> findRedemptions(ID id);
}
