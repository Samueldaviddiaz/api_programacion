package com.umanizales.api_programacion.api_programacion.model;

import com.umanizales.api_programacion.api_programacion.model.dto.AddPositionDTO;
import lombok.Data;

@Data
public class ListDE {
    private NodeDE head;
    private int count;
    private int size;

    /// #0 = Contar
    public int count() {
        /// Paso #1: La cabeza está vacía?
        if (head == null) {
            return 0;
        }
        /// Paso #2: Llamar a temporal que se posicione en la cabeza
        NodeDE temp = head;
        /// Paso #3: Crear contador que inicie en uno
        int counter = 1;
        /// Paso #4: Temporal, mientras en su siguiete haya datos, sume uno y pásese
        while (temp.getNext() != null) {
            counter += 1;
            temp = temp.getNext();
        }
        /// Paso #5: Retornar contador
        return counter;
    }

    /// #1 = Enlistar
    public Node enlist() {
        /// Paso #1: Se crea una nueva lista (SE)
        ListSE list = new ListSE();
        /// Paso #2: Si la cabeza es diferente a nulo
        if (this.head != null) {
            /// Paso #3: Llamar a temporal que se posicione en la cabeza
            NodeDE temp = this.head;
            /// Paso #4: Temporal, mientras en su siguiete hayan datos,
            while (temp != null) {
                /// Paso #5: Temporal, adicione los datos a la lista y pásese
                list.add(temp.getData());
                temp = temp.getNext();
            }
        }
        return list.getHead();
    }

    /// #2 = Adicionar al final
    public void add(Kid kid) {
        /// Paso #1: Si la cabeza está vacía, creo un nuevo costal con un niño y ahora ese es cabeza
        if (this.head == null) {
            NodeDE newNode = new NodeDE(kid);
            this.head = newNode;
        /// Paso #2: Cabeza está sujeto al previo de su siguiente
            head.getNext().setPrevious(head);
        } else {
        /// Paso #3: Si no, llamar a temporal que se pare en la cabeza
            NodeDE temp = this.head;
        /// Paso #4: Temporal, mientras en su siguiete haya datos, pásese
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
        /// Paso #5: Se sale del ciclo, el temporal está a lo último: creo un nuevo costal con un niño
            NodeDE newNode = new NodeDE(kid);
        /// Paso #6: Temporal, su siguiente es el nuevo nodo que acabamos de crear
            temp.setNext(newNode);
        /// Paso #7: Nuevo nodo, su anterior ahora es el temporal
            newNode.setPrevious(temp);
        }
        this.count++;
        /// Paso #8: Se suma 1 al contador
    }

    /// #3: Adicionar al inicio
    public void addToStart(Kid kid) {
        /// Paso #1: Se mete al niño en un nodo
        NodeDE newNode = new NodeDE(kid);
        /// Paso #2: Si la cabeza es diferente de nulo
        if (this.head != null) {
        /// Paso #3: Nuevo nodo ahora es cabeza, está sujeto al previo de su siguiente
            newNode.setNext(this.head);
            this.head.setPrevious(newNode);
        }
        /// Paso #4: Ahora la cabeza es la cabeza es el nuevo nodo y suma 1 al contador
        this.head = newNode;
        this.count++;
    }

    /// #4: Invertir
    public void invert() throws Exception {
        /// Paso #1: Si el contador es mayor a uno:
        if (this.count > 1) {
        /// Paso #2: Se crea una nueva lista
            ListDE new_list = new ListDE();
        /// Paso #3: Se llama a temporal que se posiciona en la cabeza
            NodeDE temp = this.head;
        /// Paso #4: Mientras haya datos
            while (temp != null) {
        /// Paso #5: Temporal agrega AL INICIO los datos
                new_list.addToStart(temp.getData());
        /// Paso #6: Temporal pásese
                temp = temp.getNext();
            }
        /// Paso #7: Ahora la cabeza es la cabeza de la nueva lista
            this.head = new_list.head;
        }
    }

    /// #5: Primero las niñas y luego los niños
    public void mixByGender() {
        /// Paso #1: Si hay datos
        if (head != null) {
        /// Paso #2: Si el contador es mayor a 1
            if (count() > 1) {
        /// Paso #3: Se crea una nueva lista
                ListDE newList = new ListDE();
        /// Paso #4: Se llama a temporal que se posiciona en la cabeza
                NodeDE temp = head;
        /// Paso #5: Mientras haya datos
                while (temp != null) {
        /// Paso #6: Si en los datos del género aparece una "M", de masculino
                    if (temp.getData().getGender() == 'M') {
        /// Paso #7: Se adicionan los datos a la nueva lista
                        newList.add(temp.getData());
        /// Paso #8: Si no, se adicionan los datos AL INICIO de la nueva lista
                    } else {
                        newList.addToStart(temp.getData());
                    }
        /// Paso #9: Temporal pásese
                    temp = temp.getNext();
                }
        /// Paso #8: Ahora la cabeza es la cabeza de la nueva lista
                this.head = newList.head;
            }
        }
    }

    /// #6: Borrar por posición
    public void deleteToPosition(int position) {
        /// Paso #1: Entra una posición, si la posición es 1, cabeza toma al siguiente (2) y este se convierte en cabeza, prvio conecta con cabeza
        if (position == 1) {
            head = head.getNext();
            head.getNext().setPrevious(head);
            /// Paso #2: Si no, llamar a temporal que se pare en la cabeza
        } else {
            NodeDE temp = head;
            /// Paso #3: Se crea un contador para saber la posición en la que se encuentra parado el temporal
            int count = 1;
            /// Paso #4: Mientras haya datos: El temporal está en un ciclo para parar uno antes de la posición ingresada
            while (temp != null) {
                if (count == position - 1) {
                    /// Paso #5: El temporal llegó uno antes de la posición
                    temp.setNext(temp.getNext().getNext());
                    temp.getNext().setPrevious(temp);
                    /// Paso #6: Sale del ciclo para evitar Bug
                    break;
                }
                /// Paso #7: El temporal agarra a posición más 1, es decir, el sig del sig
                temp = temp.getNext();
                /// Paso #8: Dado que se eliminó un niño, la lista se hace uno más chica
                size = -1;
            }
        }
    }

    /// #7: Borrar por dato
    public void deleteByData(String data) {
        /// Paso #1: (En cabeza) Se ingresa a los datos y a la identificación, se compara con la ingresada, si es la misma, cabeza ahora es el sig y prev se conecta a cabeza
        if (head.getData().getIdentification() == data) {
            head = head.getNext();
            head.getNext().setPrevious(head);
        } else {
        /// Paso #2: Si no, se llama a temporal, mientras haya datos:
            NodeDE temp = head;
            while (temp != null) {
        /// Paso #3: Si los datos del siguiente tienen la misma identificación ingresada:
                if (temp.getNext().getData().getIdentification() == data) {
        /// Paso #4: Temporal, agarre al siguiente de su siguiente, el previo toma a temporal y rompe el ciclo
                    temp.setNext(temp.getNext().getNext());
                    temp.getNext().setPrevious(temp);
                    break;
                }
        /// Paso #5: Temporal pásese
                temp = temp.getNext();
            }
        }
    }

    /// #8: Adicionar por posición
    public void addToPosition(AddPositionDTO addPositionDTO) {
        /// Paso #1: Si la cabeza está vacía o se desea adicionar la posición número 1
        if ((head == null) || addPositionDTO.getPosition() == 1) {
            /// Paso #2: Se adiciona al inicio por medio del método
            addToStart(addPositionDTO.getKid());
        /// Paso #3: Cabeza, ahora está sujeta al previo de su siguiente
            head.getNext().setPrevious(head);
            /// Paso #4: Si no, valido la posición
        } else {
            /// Paso #5: Si la posición es mayor a la talla, se adiciona al final
            if (addPositionDTO.getPosition() > size) {
                add(addPositionDTO.getKid());
                /// Paso #6: Si no, se llama a temporal para que se posicione en la cabeza
            } else {
                NodeDE temp = head;
                /// Paso #7: Contador inicia en 1
                int count = 1;
                /// Paso #8: Mientras el contador sea menor a la posición ingresada menos 1
                while (count < (addPositionDTO.getPosition() - 1)) {
                    /// Paso #9: Temporal pásese
                    temp = temp.getNext();
                    /// Paso #10: Contador suma 1
                    count += 1;
                }
                /// Paso #11: Se crea un nuevo nodo
                NodeDE newNode = new NodeDE(addPositionDTO.getKid());
                /// Paso #12: Nuevo nodo, su siguiente es el siguiente del temporal
                newNode.setNext(temp.getNext());
                /// Paso #13: Temporal, su siguiente es el nuevo nodo
                temp.setNext(newNode);
                /// Paso #14: Nuevo nodo, su previo es el temporal
                newNode.getNext().setPrevious(temp);
                /// Paso #15: La talla de la lista se suma en 1
                size += 1;
            }
        }
    }
}