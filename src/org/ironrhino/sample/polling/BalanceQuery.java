package org.ironrhino.sample.polling;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.metadata.Readonly;
import org.ironrhino.core.metadata.Richtable;

@Entity
@Table(name = "sample_balance_query", indexes = { @Index(columnList = "createDate desc") })
@AutoConfig
@Richtable(readonly = @Readonly(true), order = "createDate desc")
public class BalanceQuery extends BaseBalanceQuery {

	private static final long serialVersionUID = 3825969412916897020L;

}
