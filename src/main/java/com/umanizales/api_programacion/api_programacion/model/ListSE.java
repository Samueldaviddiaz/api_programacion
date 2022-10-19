package com.umanizales.api_programacion.api_programacion.model;

import com.umanizales.api_programacion.api_programacion.model.dto.AddPositionDTO;
import com.umanizales.api_programacion.api_programacion.model.dto.FirstLetterAgeDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ListSE {
    private Node head;

    private int size;

    /// #0 = Contar
    public int count() {
        /// Paso #1: La cabeza está vacía?
        if (head == null) {
            return 0;
        }
        /// Paso #2: Llamar a temporal que se posicione en la cabeza
        Node temp = head;
        /// Paso #3: Crear contador que inicie en uno
        int counter = 1;
        /// Paso #4: Temporal, mientras en su siguiete hayan datos, sume uno y pásese
        while (temp.getNext() != null) {
            counter += 1;
            temp = temp.getNext();
        }
        return counter;
    }

    /// #1 = Adicionar al final
    public void add(Kid kid) {
        /// Paso #1: Si la cabeza está vacía, creo un nuevo costal con un niño y ahora ese es cabeza
        if (head == null) {
            head = new Node(kid);
        } else {
            /// Paso #2: Sino, llamar a temporal que se pare en la cabeza
            Node temp = head;
            /// Paso #3: Temporal, mientras en su siguiete hayan datos,pásese
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            /// Paso #4: Se sale del ciclo, el temporal está a lo último: creo un nuevo costal con un niño y se agrega al final
            Node newNode = new Node(kid);
            temp.setNext(newNode);
        }
    }

    /// #2 = Adicionar al inicio
    public void addToStart(Kid kid) {
        /// Paso #1: Si la cabeza está vacía, creo un nuevo costal con un niño y ahora ese es cabeza
        if (head == null) {
            head = new Node(kid);
            /// Paso #2: Si no, creo un nuevo costal con un niño
        } else {
            Node newNode = new Node(kid);
            /// Paso #3: Ahora el nuevo costal toma los datos del siguiente y después se convierte en la cabeza
            newNode.setNext(head);
            head = newNode;
        }
    }

    /// #3 = Borrar por posición
    public void deleteToPosition(int position) {
        /// Paso #1: Entra una posición, si la posición es 1, cabeza toma al siguiente (2) y este se convierte en cabeza
        if (position == 1) {
            head = head.getNext();
        /// Paso #2: Si no, llamar a temporal que se pare en la cabeza
        } else {
            Node temp = head;
        /// Paso #3: Se crea un contador para saber la posición en la que se encuentra parado el temporal
            int count = 1;
        /// Paso #4: Mientras haya datos: El temporal está en un ciclo para parar uno antes de la posición ingresada
            while (temp != null) {
        /// Paso #5: El temporal llegó uno antes de la posición y agarra a posición más 1, es decir, el sig del sig
                if (count == position - 1) {
                    temp.setNext(temp.getNext().getNext());
        /// Paso #6: Sale del ciclo para evitar Bug
                    break;
                }
        /// Paso #7: Temporal pásese
                temp = temp.getNext();
                /// Paso #8: Dado que se eliminó un niño, la lista se hace uno más chica
                size -= 1;
            }
        }
    }

    /// #4 = Borrar por dato
    public void deleteByData(String data) {
        /// Paso #1: (En cabeza) Se ingresa a los datos y a la identificación, se compara con la ingresada, si es la misma, cabeza ahora es el sig
        if (head.getData().getIdentification() == data) {
            head = head.getNext();
        } else {
            /// Paso #2: Si no, se llama a temporal, mientras haya datos:
            Node temp = head;
            while (temp != null) {
                /// Paso #3: Si los datos del siguiente tienen la misma identificación ingresada:
                if (temp.getNext().getData().getIdentification() == data) {
                    /// Paso #4: Temporal, agarre al sig de su sig y rompa el ciclo
                    temp.setNext(temp.getNext().getNext());
                    break;
                }
                /// Paso #5: Pásese
                temp = temp.getNext();
            }
        }
    }

    /// #5 Cambiar extremos
    public void changeFirstLast() {
        /// Paso #1: Si el contador es mayor a 1, temporal se posiciona en cabeza
        if (count() > 1) {
            Node temp = head;
            /// Paso #2: Temporal toma los datos de la cabeza (1)
            Kid temp1 = head.getData();
            /// Paso #3: Mientras haya datos
            while (temp != null) {
                /// Paso #4: Si el siguiente del temporal es nulo, se le indica que ahora es la cabeza (2)
                if (temp.getNext() == null) {
                    head.setData(temp.getData());
                    /// Paso #5: Pone los datos de la cabeza (1), se rompe el ciclo
                    temp.setData(temp1);
                    break;
                }
                /// Paso #6: Temporal pásese
                temp = temp.getNext();
            }
        }
    }

    /// #6 = Invertir
    public void invert() {
        /// Paso #1: Si cabeza es diferente a nulo
        if (head != null) {
            /// Paso #2: Se crea una nueva lista
            ListSE newList = new ListSE();
            /// Paso #3: Se llama a temporal y se posiciona en la cabeza
            Node temp = head;
            /// Paso #4: Mientras hayan datos, temporal, ponga los datos de la lista en la nueva lista AL INICIO
            while (temp != null) {
                newList.addToStart(temp.getData());
                /// Paso #5: Temporal pásese
                temp = temp.getNext();
            }
            /// Paso #6: Ahora la cabeza es la cabeza de la nueva lista
            head = newList.head;
        }
    }

    /// #7 Primero las niñas
    public void mixByGender() {
        /// Paso #1: Si hay datos
        if (head != null) {
            /// Paso #2: Si el contador es mayor a 1
            if (count() > 1) {
        /// Paso #3: Se crea una nueva lista
                ListSE newList = new ListSE();
        /// Paso #4: Se llama a temporal que se posiciona en la cabeza
                Node temp = head;
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
                this.head = newList.head;
        /// Paso #8: Ahora la cabeza es la cabeza de la nueva lista
            }
        }
    }

    /// #8 = Adicionar por posición
    public void addToPosition(AddPositionDTO addPositionDTO) {
        /// Paso #1: Si la cabeza está vacía o se desea adicionar la posición número 1
        if ((head == null) || addPositionDTO.getPosition() == 1) {
        /// Paso #2: Se adiciona al inicio por medio del método
            addToStart(addPositionDTO.getKid());
        /// Paso #3: Si no, valido la posición
        } else {
        /// Paso #4: Si la posición es mayor a la talla, se adiciona al final
            if (addPositionDTO.getPosition() > size) {
                add(addPositionDTO.getKid());
        /// Paso #5: Si no, se llama a temporal para que se posicione en la cabeza
            } else {
                Node temp = head;
        /// Paso #6: Contador inicia en 1
                int count = 1;
        /// Paso #7: Mientras el contador sea menor a la posición ingresada menos 1
                while (count < (addPositionDTO.getPosition() - 1)) {
        /// Paso #8: Temporal pásese
                    temp = temp.getNext();
        /// Paso #9: Contador suma 1
                    count += 1;
                }
        /// Paso #10: Se crea un nuevo nodo
                Node newNode = new Node(addPositionDTO.getKid());
        /// Paso #11: Nuevo nodo, su siguiente es el siguiente del temporal
                newNode.setNext(temp.getNext());
        /// Paso #12: Temporal, su siguiente es el nuevo nodo
                temp.setNext(newNode);
        /// Paso #13: La talla de la lista se suma en 1
                size += 1;
            }
        }
    }

    /// #9 = Intercalar
    public void mix() {
        /// Paso #1: Si la talla de la lista es mayor a uno
        if (size > 1) {
        /// Paso #2: Creo un contador que inicie en 1 para género masculino
            int contM = 1;
        /// Paso #3: Creo un contador que inicie en 2 para género femenino
            int contF = 2;
        /// Paso #4: Llamo a temporal que se posicione en la cabeza
            Node temp = head;
        /// Paso #5: Se crea una nueva lista
            ListSE newlist = new ListSE();
        /// Paso #6: Mientras haya datos
            while (temp != null) {
        /// Paso #7: Si en los datos, el género es "M"
                if (temp.getData().getGender() == 'M') {
        /// Paso #8: Sí el contador masculino es mayor al tamaño de la talla de la lista
                    if (contM > newlist.size) {
        /// Paso #9: El temporal adiciona los datos a la nueva lista
                        newlist.add(temp.getData());
        /// Paso #10: Si no,
                    } else {
                        newlist.addToPosition(new AddPositionDTO(contM, temp.getData()));
                    }
        /// Paso #11: El contador masculino suma 2
                    contM += 2;
        /// Paso #12: Si no, se agrega al niño por posición
                } else {
        /// Paso #13: Si el contador femenino es mayor a la talla de la lista
                    if (contF > newlist.size) {
        /// Paso #14: Temporal, agregue los datos a la nueva lista
                        newlist.add(temp.getData());
        /// Paso #15: Si no, se agrega a la niña por posición
                    } else {
                        newlist.addToPosition(new AddPositionDTO(contF, temp.getData()));
                    }
        /// Paso #16: El contador femenino suma 2
                    contF += 2;
                }
        /// Paso #17: Temporal pásese
                temp = temp.getNext();
            }
        }
    }

    /// #10 = Eliminar por letra y por edad
    public void deleteLetterAge(FirstLetterAgeDTO firstLetterAgeDTO) {
        /// Paso #1: Si la lista tiene datos
        if (head !=null){
        /// Paso #2: Se llama a temporal y se posiciona en la cabeza
            Node temp = head;
        /// Paso #3: Se crea una nueva lista
            ListSE newlist= new ListSE();
        /// Paso #4: Mientras haya datos
            while (temp != null){
        /// Paso #5: Sí en los datos, la primera letra del nombre es diferente a la ingresada
                if(temp.getData().getName().charAt(0) != firstLetterAgeDTO.getLetter()
                        //charAt() Permite seleccionar el primer caracter de un string
        /// Paso #6: Ó en los datos, la edad es diferente a la ingresada
                        || temp.getData().getAge() != firstLetterAgeDTO.getAge()){
        /// Paso #7: El temporal adiciona los datos a la nueva lista
                    newlist.add(temp.getData());
                }
        /// Paso #8: Temporal pásese
                temp = temp.getNext();
            }
        /// Paso #9: Ahora la cabeza es la cabeza de la nueva lista
            head= newlist.getHead();
        }
    }

    /// #11 = Rango por edades
    public int rangeByAge(int initial, int end){
        /// Paso #1: Se crea un contador que inicia desde 0
        int count =0;
        /// Paso #2: Si la cabeza es diferente a nulo
        if (head != null) {
        /// Paso #3: Se llama a temporal que se posiciona en la cabeza
            Node temp = head;
        /// Paso #4: Mientras haya datos
            while(temp != null) {
        /// Paso #5: Si la edad es mayor en el inicial y menor en el final
                if(temp.getData().getAge() >= initial && temp.getData().getAge() <=end) {
        /// Paso #6: Contador suma 1
                    count +=1;
                }
        /// Paso #7: Temporal pásese
                temp.getNext();
            }
        }
        /// Paso #8: Retornar contador
        return count;
    }
}
