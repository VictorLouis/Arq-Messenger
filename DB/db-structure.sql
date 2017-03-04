-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema messengerDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema messengerDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `messengerDB` ;
USE `messengerDB` ;

-- -----------------------------------------------------
-- Table `messengerDB`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `messengerDB`.`User` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `messengerDB`.`conversation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `messengerDB`.`conversation` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Date` DATE NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `messengerDB`.`UserConversation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `messengerDB`.`UserConversation` (
  `IdUser` INT NOT NULL,
  `IdConversation` INT NOT NULL,
  PRIMARY KEY (`IdUser`, `IdConversation`),
  INDEX `fk_UserConversation_conversation1_idx` (`IdConversation` ASC),
  CONSTRAINT `fk_UserConversation_User`
    FOREIGN KEY (`IdUser`)
    REFERENCES `messengerDB`.`User` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_UserConversation_conversation1`
    FOREIGN KEY (`IdConversation`)
    REFERENCES `messengerDB`.`conversation` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `messengerDB`.`Authentication`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `messengerDB`.`Authentication` (
  `Password` VARCHAR(45) NOT NULL,
  `User_Id` INT NOT NULL,
  PRIMARY KEY (`User_Id`),
  INDEX `fk_Authentication_User1_idx` (`User_Id` ASC),
  CONSTRAINT `fk_Authentication_User1`
    FOREIGN KEY (`User_Id`)
    REFERENCES `messengerDB`.`User` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `messengerDB`.`Event`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `messengerDB`.`Event` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Descripcion` VARCHAR(45) NOT NULL,
  `User_Id` INT NOT NULL,
  PRIMARY KEY (`Id`, `User_Id`),
  INDEX `fk_Event_User1_idx` (`User_Id` ASC),
  CONSTRAINT `fk_Event_User1`
    FOREIGN KEY (`User_Id`)
    REFERENCES `messengerDB`.`User` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `messengerDB`.`Message`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `messengerDB`.`Message` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Date` DATE NOT NULL,
  `Text` LONGTEXT NOT NULL,
  `IdConversation` INT NOT NULL,
  `User_Id` INT NOT NULL,
  PRIMARY KEY (`Id`, `IdConversation`, `User_Id`),
  INDEX `fk_Message_conversation1_idx` (`IdConversation` ASC),
  INDEX `fk_Message_User1_idx` (`User_Id` ASC),
  CONSTRAINT `fk_Message_conversation1`
    FOREIGN KEY (`IdConversation`)
    REFERENCES `messengerDB`.`conversation` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Message_User1`
    FOREIGN KEY (`User_Id`)
    REFERENCES `messengerDB`.`User` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

