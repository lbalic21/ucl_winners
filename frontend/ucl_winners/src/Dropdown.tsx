import React, { useEffect, useState } from 'react';

type DropDownProps = {
  attributes: string[];
  showDropDown: boolean;
  toggleDropDown: Function;
  attributeSelection: Function;
};

const DropDown: React.FC<DropDownProps> = ({
  attributes,
  attributeSelection,
}: DropDownProps): JSX.Element => {
  const [showDropDown, setShowDropDown] = useState<boolean>(false);

  /**
   * Handle passing the attribute name
   * back to the parent component
   *
   * @param attribute  The selected attribute
   */
  const onClickHandler = (attribute: string): void => {
    attributeSelection(attribute);
  };

  useEffect(() => {
    setShowDropDown(showDropDown);
  }, [showDropDown]);

  return (
    <>
      <div className={showDropDown ? 'dropdown' : 'dropdown active'}>
        {attributes.map(
          (attribute: string, index: number): JSX.Element => {
            return (
              <p
                key={index}
                onClick={(): void => {
                  onClickHandler(attribute);
                }}
              >
                {attribute}
              </p>
            );
          }
        )}
      </div>
    </>
  );
};

export default DropDown;
