-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema apl_corp
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `apl_corp` ;

-- -----------------------------------------------------
-- Schema apl_corp
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `apl_corp` DEFAULT CHARACTER SET utf8 ;
USE `apl_corp` ;

-- -----------------------------------------------------
-- Table `apl_corp`.`endereco`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `apl_corp`.`endereco` ;

CREATE TABLE IF NOT EXISTS `apl_corp`.`endereco` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `logradouro` VARCHAR(45) NULL,
  `numero` VARCHAR(45) NOT NULL,
  `cep` VARCHAR(45) NOT NULL,
  `uf` VARCHAR(45) NOT NULL,
  `municipio` VARCHAR(255) NOT NULL,
  `bairro` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `apl_corp`.`pessoa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `apl_corp`.`pessoa` ;

CREATE TABLE IF NOT EXISTS `apl_corp`.`pessoa` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_endereco` INT NOT NULL,
  `identidade` VARCHAR(45) NULL,
  `nome` VARCHAR(45) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `cpf` VARCHAR(45) NULL,
  `sexo` VARCHAR(45) NULL,
  `celular` VARCHAR(45) NULL,
  `dt_nasc` DATE NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_pessoa_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_pessoa_endereco1_idx` (`id_endereco` ASC) VISIBLE,
  CONSTRAINT `fk_pessoa_endereco1`
    FOREIGN KEY (`id_endereco`)
    REFERENCES `apl_corp`.`endereco` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `apl_corp`.`fale_conosco`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `apl_corp`.`fale_conosco` ;

CREATE TABLE IF NOT EXISTS `apl_corp`.`fale_conosco` (
  `id` INT NOT NULL,
  `id_pessoa` INT NOT NULL,
  `data` DATE NOT NULL,
  `assunto` VARCHAR(45) NOT NULL,
  `texto` LONGTEXT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_fale_conosco_pessoa_idx` (`id_pessoa` ASC) VISIBLE,
  CONSTRAINT `fk_fale_conosco_pessoa`
    FOREIGN KEY (`id_pessoa`)
    REFERENCES `apl_corp`.`pessoa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `apl_corp`.`ano_escolaridade`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `apl_corp`.`ano_escolaridade` ;

CREATE TABLE IF NOT EXISTS `apl_corp`.`ano_escolaridade` (
  `id` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `apl_corp`.`unidade_escolar`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `apl_corp`.`unidade_escolar` ;

CREATE TABLE IF NOT EXISTS `apl_corp`.`unidade_escolar` (
  `id` INT NOT NULL,
  `id_endereco` INT NOT NULL,
  `id_ano_escolaridade` INT NOT NULL,
  `nome` VARCHAR(255) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_unidade_escolar_endereco1_idx` (`id_endereco` ASC) VISIBLE,
  INDEX `fk_unidade_escolar_ano_escolaridade1_idx` (`id_ano_escolaridade` ASC) VISIBLE,
  CONSTRAINT `fk_unidade_escolar_endereco1`
    FOREIGN KEY (`id_endereco`)
    REFERENCES `apl_corp`.`endereco` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_unidade_escolar_ano_escolaridade1`
    FOREIGN KEY (`id_ano_escolaridade`)
    REFERENCES `apl_corp`.`ano_escolaridade` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `apl_corp`.`unidade_escolar_has_ano_escolaridade`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `apl_corp`.`unidade_escolar_has_ano_escolaridade` ;

CREATE TABLE IF NOT EXISTS `apl_corp`.`unidade_escolar_has_ano_escolaridade` (
  `unidade_escolar_id` INT NOT NULL,
  `ano_escolaridade_id` INT NOT NULL,
  `num_vagas` INT NOT NULL,
  `data` DATE NOT NULL,
  PRIMARY KEY (`unidade_escolar_id`, `ano_escolaridade_id`),
  INDEX `fk_unidade_escolar_has_ano_escolaridade_ano_escolaridade1_idx` (`ano_escolaridade_id` ASC) VISIBLE,
  INDEX `fk_unidade_escolar_has_ano_escolaridade_unidade_escolar1_idx` (`unidade_escolar_id` ASC) VISIBLE,
  CONSTRAINT `fk_unidade_escolar_has_ano_escolaridade_unidade_escolar1`
    FOREIGN KEY (`unidade_escolar_id`)
    REFERENCES `apl_corp`.`unidade_escolar` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_unidade_escolar_has_ano_escolaridade_ano_escolaridade1`
    FOREIGN KEY (`ano_escolaridade_id`)
    REFERENCES `apl_corp`.`ano_escolaridade` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `apl_corp`.`responsavel`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `apl_corp`.`responsavel` ;

CREATE TABLE IF NOT EXISTS `apl_corp`.`responsavel` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_pessoa` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_responsavel_pessoa1_idx` (`id_pessoa` ASC) VISIBLE,
  CONSTRAINT `fk_responsavel_pessoa1`
    FOREIGN KEY (`id_pessoa`)
    REFERENCES `apl_corp`.`pessoa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `apl_corp`.`aluno`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `apl_corp`.`aluno` ;

CREATE TABLE IF NOT EXISTS `apl_corp`.`aluno` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_responsavel` INT NOT NULL,
  `id_pessoa` INT NOT NULL,
  `naturalidade` VARCHAR(45) NOT NULL,
  `nome_mae` VARCHAR(255) NOT NULL,
  `nome_pai` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_aluno_pessoa1_idx` (`id_pessoa` ASC) VISIBLE,
  INDEX `fk_aluno_responsavel1_idx` (`id_responsavel` ASC) VISIBLE,
  CONSTRAINT `fk_aluno_pessoa1`
    FOREIGN KEY (`id_pessoa`)
    REFERENCES `apl_corp`.`pessoa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_aluno_responsavel1`
    FOREIGN KEY (`id_responsavel`)
    REFERENCES `apl_corp`.`responsavel` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `apl_corp`.`tipo_funcionario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `apl_corp`.`tipo_funcionario` ;

CREATE TABLE IF NOT EXISTS `apl_corp`.`tipo_funcionario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `apl_corp`.`funcionario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `apl_corp`.`funcionario` ;

CREATE TABLE IF NOT EXISTS `apl_corp`.`funcionario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `matricula` VARCHAR(45) NOT NULL,
  `id_pessoa` INT NOT NULL,
  `id_funcionario` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_funcionario_pessoa1_idx` (`id_pessoa` ASC) VISIBLE,
  INDEX `fk_funcionario_tipo_funcionario1_idx` (`id_funcionario` ASC) VISIBLE,
  CONSTRAINT `fk_funcionario_pessoa1`
    FOREIGN KEY (`id_pessoa`)
    REFERENCES `apl_corp`.`pessoa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_funcionario_tipo_funcionario1`
    FOREIGN KEY (`id_funcionario`)
    REFERENCES `apl_corp`.`tipo_funcionario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `apl_corp`.`solicitacao`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `apl_corp`.`solicitacao` ;

CREATE TABLE IF NOT EXISTS `apl_corp`.`solicitacao` (
  `id` INT NOT NULL,
  `id_aluno` INT NOT NULL,
  `id_responsavel` INT NOT NULL,
  `id_unidade_escolar` INT NOT NULL,
  `id_ano_escolaridade` INT NOT NULL,
  `protocolo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_solicitacao_responsavel1_idx` (`id_responsavel` ASC) VISIBLE,
  INDEX `fk_solicitacao_aluno1_idx` (`id_aluno` ASC) VISIBLE,
  INDEX `fk_solicitacao_unidade_escolar_has_ano_escolaridade1_idx` (`id_unidade_escolar` ASC, `id_ano_escolaridade` ASC) VISIBLE,
  CONSTRAINT `fk_solicitacao_responsavel1`
    FOREIGN KEY (`id_responsavel`)
    REFERENCES `apl_corp`.`responsavel` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_solicitacao_aluno1`
    FOREIGN KEY (`id_aluno`)
    REFERENCES `apl_corp`.`aluno` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_solicitacao_unidade_escolar_has_ano_escolaridade1`
    FOREIGN KEY (`id_unidade_escolar` , `id_ano_escolaridade`)
    REFERENCES `apl_corp`.`unidade_escolar_has_ano_escolaridade` (`unidade_escolar_id` , `ano_escolaridade_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `apl_corp`.`solicitacao_has_responsavel`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `apl_corp`.`solicitacao_has_responsavel` ;

CREATE TABLE IF NOT EXISTS `apl_corp`.`solicitacao_has_responsavel` (
  `id_solicitacao` INT NOT NULL,
  `id_responsavel` INT NOT NULL,
  `data` DATE NOT NULL,
  PRIMARY KEY (`id_solicitacao`, `id_responsavel`),
  INDEX `fk_solicitacao_has_responsavel_responsavel1_idx` (`id_responsavel` ASC) VISIBLE,
  INDEX `fk_solicitacao_has_responsavel_solicitacao1_idx` (`id_solicitacao` ASC) VISIBLE,
  CONSTRAINT `fk_solicitacao_has_responsavel_solicitacao1`
    FOREIGN KEY (`id_solicitacao`)
    REFERENCES `apl_corp`.`solicitacao` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_solicitacao_has_responsavel_responsavel1`
    FOREIGN KEY (`id_responsavel`)
    REFERENCES `apl_corp`.`responsavel` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `apl_corp`.`noticia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `apl_corp`.`noticia` ;

CREATE TABLE IF NOT EXISTS `apl_corp`.`noticia` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_funcionario` INT NOT NULL,
  `ano` DATE NOT NULL,
  `conteudo` LONGTEXT NOT NULL,
  `titulo` VARCHAR(45) NOT NULL,
  `autor` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_noticia_funcionario1_idx` (`id_funcionario` ASC) VISIBLE,
  CONSTRAINT `fk_noticia_funcionario1`
    FOREIGN KEY (`id_funcionario`)
    REFERENCES `apl_corp`.`funcionario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `apl_corp`.`lista_espera`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `apl_corp`.`lista_espera` ;

CREATE TABLE IF NOT EXISTS `apl_corp`.`lista_espera` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `aluno_id` INT NOT NULL,
  `data` DATE NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_lista_espera_aluno1_idx` (`aluno_id` ASC) VISIBLE,
  CONSTRAINT `fk_lista_espera_aluno1`
    FOREIGN KEY (`aluno_id`)
    REFERENCES `apl_corp`.`aluno` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
